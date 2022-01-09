package app.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import app.binarytree.BinaryTree;
import app.binarytree.Node;

public class ConversionFromInfixToPrefix 
{
	static Node<Object> root = null;
	static String preExpn;
//	public static String convertToPrefix(String expression)
//	{
//		String prefixExpression = "";
//		int countOperand = 0;
//		
//		Stack<Character> stkCharachter = new Stack<Character>();
//		Queue<String> queString = new LinkedList<String>();
//		Stack<Node<Object>> stkNode = new Stack<Node<Object>>();
//		
//		BinaryTree<Object> expressionBinaryTree = new BinaryTree<Object>();
//		
//		for(int i = 0; i < expression.length(); ++i)
//		{
//			if((expression.charAt(i) == '(') || isOperator(expression.charAt(i)))
//				stkCharachter.push(expression.charAt(i));
//			
//			if(isOperand(expression.charAt(i)))
//			{
//				queString.add(expression.charAt(i)+"");
//				++countOperand;
//			}	
//			
//			if(countOperand == 2)
//			{
//				if(isOperator(stkCharachter.peek()))
//				{
//					expressionBinaryTree.insert(stkCharachter.pop());
//					
//					expressionBinaryTree.insert(queString.remove());
//					--countOperand;
//					expressionBinaryTree.insert(queString.remove());
//					--countOperand;
//				}
//			}
//		}
//		
//		return prefixExpression;
//	}
//	
//	private static boolean isOperand(char c) 
//	{
//		String character = c+"";
//		String regexOperand = "[a-z]";
//		if(character.matches(regexOperand))
//			return true;
//		
//		return false;
//	}
//
//	private static boolean isOperator(char c)
//	{
//		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
//			return true;
//		
//		return false;		
//	}
	
	@SuppressWarnings("rawtypes")
	private static void intopre(Object obj, Node<Object> current)
	{
		String element;
		element = (String)((Node) obj).element;
		
		String LC = "", RC = "";
		
		Stack<Node<Object>> stkNode = new Stack<Node<Object>>();
		Node<Object> newNode;
		
		for(int i = element.length()-1; i>=0; --i)
		{
			if(element.charAt(i) == '+' || element.charAt(i) == '-')
			{
				int  j = i+1;
				while(j<=element.length()-1)
				{
					RC += element.charAt(j);
					++j;
				}
				
				j = 0;
				while(j<i)
				{
					LC += element.charAt(j);
					++j;
				}
				System.out.println(element.charAt(i)+"");
				newNode = new Node<Object>(element.charAt(i)+"");
				preExpn += (String)newNode.element;
				if(root == null)
					root = newNode;
				
				current = newNode;
				newNode.leftChild = new Node<Object>(LC);
				newNode.rightChild = new Node<Object>(RC);
				
				intopre(newNode.leftChild, current);
				intopre(newNode.rightChild, current);
				
			}
			else
			if(element.charAt(i) == '*' || element.charAt(i) == '/')
			{
				int  j = i+1;
				while(j<=element.length()-1)
				{
					RC += element.charAt(j);
					++j;
				}
				
				j = 0;
				while(j<i)
				{
					LC += element.charAt(j);
					++j;
				}
				System.out.println(element.charAt(i)+"");
				newNode = new Node<Object>(element.charAt(i)+"");
				preExpn += (String)newNode.element;
				if(root == null)
					root = newNode;
				current = newNode;
				newNode.leftChild = new Node<Object>(LC);
				newNode.rightChild = new Node<Object>(RC);
				
				intopre(newNode.leftChild.element, current);
				intopre(newNode.rightChild.element, current);
			}
			
			if(current!= null)
			{
				Node<Object> leafNode = new Node<Object>(RC);
				stkNode.push(leafNode);
				preExpn += (String)leafNode.element;
				if(current.leftChild == null)
					current.leftChild = stkNode.pop();
				else
					current.rightChild = stkNode.pop();
			}
		}
	}
	
	
	public static String inToPre(String expn)
	{
		Node<Object> newNode = new Node<Object>(expn);
		intopre(newNode, null);
		return preExpn;
	}
}
