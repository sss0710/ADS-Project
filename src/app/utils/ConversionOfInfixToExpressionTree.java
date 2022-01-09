package app.utils;

import java.util.Stack;

import app.treenode.Node;

public class ConversionOfInfixToExpressionTree
{
	static Node root;
	static String preExpn;
	static String postExpn;
	
	public ConversionOfInfixToExpressionTree()
	{
		root = null;
		preExpn = "";
		postExpn = "";
	}
	
	public Node creatingExpressionTreefromInfixExpression(String expression)
	{
	    Stack<Node> stkNode = new Stack<>();
	    Stack<Character> stkChar = new Stack<>();
	    
	    Node parent, rChild, lChild;
	 
	    int []precedence = new int[100];
	    precedence['+'] = precedence['-'] = 1;
	    precedence['/'] = precedence['*'] = 2;
	    precedence['^'] = 3;
	    precedence[')'] = 0;
	    
	    for (int i = 0; i < expression.length(); i++)
	    {
	    	char expnChar = expression.charAt(i);
	    	
	        if (expnChar == '(') 
	            stkChar.add(expnChar);
	        else 
	        	if (Character.isAlphabetic(expnChar))
	        	{
	        		parent = new Node(expnChar+"");
	        		stkNode.add(parent);
	        	}
	        	else 
	        		if (precedence[expnChar] > 0)
	        		{
	        			while (!stkChar.isEmpty() && stkChar.peek() != '(' && 
	            		((expnChar != '^' && precedence[stkChar.peek()] >= precedence[expnChar]) || 
	            		(expnChar == '^' && precedence[stkChar.peek()] > precedence[expnChar])))
	        			{
	        				parent = new Node(stkChar.peek()+"");
	        				stkChar.pop();
	 
	        				rChild = stkNode.peek();
	        				stkNode.pop();
	 
	        				lChild = stkNode.peek();
	        				stkNode.pop();
	 
	        				parent.leftChild = lChild;
	        				parent.rightChild = rChild;
	 
	        				stkNode.add(parent);
	        			}
	 
	        			stkChar.push(expnChar);
	        		}
	        		else 
	        			if (expnChar == ')') 
	        			{
	        				while (!stkChar.isEmpty() && stkChar.peek() != '(')
	        				{
	        					parent = new Node(stkChar.peek()+"");
	        					stkChar.pop();
	        					rChild = stkNode.peek();
	        					stkNode.pop();
	        					lChild = stkNode.peek();
	        					stkNode.pop();
	        					parent.leftChild = lChild;
	        					parent.rightChild = rChild;
	        					stkNode.add(parent);
	        				}
	        				stkChar.pop();
	        			}
	    }
	    parent = stkNode.peek();
	    return parent;
	}


	public String postorder(Node root)
	{
	    if (root != null)
	    {
	       postorder(root.leftChild);
	       postorder(root.rightChild);
	       postExpn += root.element;
	    }
	    return postExpn;
	}

	public String preorder(Node root)
	{
	    if (root != null)
	    {
	    	preExpn += root.element;
	    	preorder(root.leftChild);
	    	preorder(root.rightChild);  
	    }
	    return preExpn;
	}
}
