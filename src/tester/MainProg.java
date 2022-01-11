package tester;

import java.util.Scanner;

import app.exception.InvalidExpressionException;
import app.treenode.Node;
import app.utils.ConversionOfInfixToExpressionTree;

import static app.utils.ValidationUtils.validateInfixExpression;

public class MainProg 
{
	public static void main(String[] args) throws InvalidExpressionException 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("*****Welcome to the Expression Calculator*****");
			ConversionOfInfixToExpressionTree conversion;
			
			String infixExpression;
			
			Node root;
			String preOrderExpression="";
			String postOrderExpression="";
			boolean flag = true;
			
			while(flag)
			{
				
				System.out.println("Select the order in which you wish to convert the expression"
						+ "\n1. Enter a new Infix Expression"
						+ "\n2. Prefix Expression"
						+ "\n3. Postfix Expression"
						+ "\n4. Prefix & Postfix Expression"
						+ "\n5. Exit"
						+ "\nChoose an option from the above list");	
				try
				{
					switch (sc.nextInt()) 
					{
						case 1:
							System.out.println("Enter valid Infix Expression");
							infixExpression = validateInfixExpression(sc.next());
							conversion = new ConversionOfInfixToExpressionTree();
							root = conversion.creatingExpressionTreefromInfixExpression("(" + infixExpression.toLowerCase() + ")");
						
							System.out.println("The infix expression is : " +infixExpression +"\n");
							preOrderExpression = conversion.preorder(root);
							postOrderExpression = conversion.postorder(root);
						
						break;
						
						case 2: 
							System.out.println("The prefix expression is : " +preOrderExpression+"\n");
							break;
							
						case 3: 
							System.out.println("The postfix expression is : " +postOrderExpression+"\n");
							break;
							
						case 4: 
							System.out.println("The prefix expression is : " +preOrderExpression);
							System.out.println("The postfix expression is : " +postOrderExpression +"\n");
							break;
								
						case 5:
							flag = false;
							System.out.println("Call us anytime, Bye for now!!!!");
							break;
							
						default:
							System.out.println("Enter valid choice");
							
					}
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}
			}
		}
	}
}
