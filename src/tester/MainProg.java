package tester;

import java.util.Scanner;

import app.binarytree.Node;
import app.exception.InvalidExpressionException;
import app.utils.ConversionFromInfixToPrefix;

import static app.utils.ValidationUtils.validateInfixExpression;

public class MainProg 
{
	public static void main(String[] args) throws InvalidExpressionException 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("*****Welcome to the Expression Calculator*****");
			ConversionFromInfixToPrefix conversion;
			
			System.out.println("Enter valid Infix Expression");
			String infixExpression = validateInfixExpression(sc.next());
			
			conversion = new ConversionFromInfixToPrefix();
			Node root = conversion.creatingExpressionTreefromInfixExpression("(" + infixExpression.toLowerCase() + ")");
			String preOrderExpression = conversion.preorder(root);
			String postOrderExpression = conversion.postorder(root);
			boolean flag = true;
			
			while(flag)
			{
				
				System.out.println("Select the order in which you wish to convert the expression"
						+ "\n1. Prefix Expression"
						+ "\n2. Postfix Expression"
						+ "\n3. Prefix & Postfix Expression"
						+ "\n4. Enter a new Infix Expression"
						+ "\n5. Exit"
						+ "\nChoose an option from the above list");	
				try
				{
					switch (sc.nextInt()) 
					{
						case 1: 
							System.out.println("The prefix expression is : " +preOrderExpression);
							break;
							
						case 2: 
							System.out.println("The postfix expression is : " +postOrderExpression);
							break;
							
						case 3: 
							System.out.println("The prefix expression is : " +preOrderExpression);
							System.out.println("The postfix expression is : " +postOrderExpression);
							break;
							
						case 4:
							System.out.println("Enter valid Infix Expression");
							infixExpression = validateInfixExpression(sc.next());
							conversion = new ConversionFromInfixToPrefix();
							root = conversion.creatingExpressionTreefromInfixExpression("(" + infixExpression.toLowerCase() + ")");
							
							System.out.println("The infix expression is : " +infixExpression);
							preOrderExpression = conversion.preorder(root);
							postOrderExpression = conversion.postorder(root);
							
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
