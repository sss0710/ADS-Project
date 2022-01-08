package tester;

import java.util.Scanner;

import static app.utils.ValidationUtils.validateInfixExpression;

public class MainProg 
{
	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("*****Welcome to the Expression Calculator*****");
			System.out.println("Select the type of expression you want to evaluate"
								+ "\n1. Prefix Expression"
								+ "\n2. Infix Expression"
								+ "\n3. Postfix Expression"
								+ "\n4. Exit"
								+ "\nChoose an option from the above list");
			boolean flag = true;
			String expn;
			while(flag)
			{
				try
				{
					switch (sc.nextInt()) 
					{
						case 1: 
							System.out.println("Enter valid Prefix Expression");
							//expn = validatePrefixExpression(sc.next());
							break;
							
						case 2: 
							System.out.println("Enter valid Infix Expression");
							expn = validateInfixExpression(sc.next());
							break;
							
						case 3: 
							System.out.println("Enter valid Postfix Expression");
							
							break;
							
						case 4:
							flag = false;
							System.out.println("Call us anytime, Bye for now!!!!");
							break;
							
						default:
							System.out.println("Enter valid choice");
							
					}
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}

}
