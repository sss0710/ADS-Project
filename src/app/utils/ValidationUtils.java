package app.utils;

import java.util.Stack;

import app.exception.InvalidExpressionException;

public class ValidationUtils<T> 
{
//	public static String validatePrefixExpression(String expn)
//	{
//		Stack<Character> stkChar = new Stack<>();
//		char[] operands = 
//		
//		for(int i = 0; i < expn.length(); ++i)
//		{
//			if(expn.charAt(i) == '+' || expn.charAt(i) == '-' || expn.charAt(i) == '*' || expn.charAt(i) == '/' || expn.charAt(i) == '^')
//				stkChar.push(expn.charAt(i));
//			
//			if(expn.charAt(i) == )
//		}
//		
//		return expn;
//	}
	
	public static String validateInfixExpression(String expn) throws InvalidExpressionException
	{
		int expnLength = expn.length();
		
		if(expn.charAt(0) == '+' || expn.charAt(0) == '-' || expn.charAt(0) == '*' || expn.charAt(0) == '/' || expn.charAt(0) == '^' || expn.charAt(0) == ')')
			throw new InvalidExpressionException("Invalid Expression!!!!!!!!!");
		
		if(expn.charAt(expnLength-1) == '+' || expn.charAt(expnLength-1) == '-' || expn.charAt(expnLength-1) == '*' || expn.charAt(expnLength-1) == '/' || expn.charAt(expnLength-1) == '^' || expn.charAt(expnLength-1) == '(')
			throw new InvalidExpressionException("Invalid Expression!!!!!!!!!");
		
		validateBrackets(expn);
		
		validateCountOperatorOperand(expn);
		
		for(int i = 0; i < expnLength-1; ++i)
			validateOccurences(expn.charAt(i), expn.charAt(i+1));
		
		return expn;
	}

	private static void validateOccurences(char charAtCurrent, char charAtNext) throws InvalidExpressionException 
	{
		String charac1 = charAtCurrent+"";
		String charac2 = charAtNext+"";
		
		String regexOperator = "(\\+|-|\\*|\\/|^)";
		String regexOperand = "[a-z]";
		
		if(charac1.matches(regexOperand) && charac2.matches(regexOperand))
			throw new InvalidExpressionException("Two operands found together!!!!!");
		else
			if(charac1.matches(regexOperator) && charac2.matches(regexOperator))
				throw new InvalidExpressionException("Two operators found together!!!!!");
	}

	private static void validateCountOperatorOperand(String expn) throws InvalidExpressionException 
	{
		int countOperator = 0;
		int countOperand = 0;
		
		String charac;
		String regexOperator = "(\\+|-|\\*|\\/|^)";
		String regexOperand = "[a-z]";
		for(int i = 0; i < expn.length(); i++)
		{
			charac = expn.charAt(i)+"";
			
			if(charac.matches(regexOperand))
				++countOperand;
				
			if(charac.matches(regexOperator))
				++countOperator;		
		}
		
		if(countOperand != countOperator + 1)
			throw new InvalidExpressionException("Please enter valid expression");
	}

	private static void validateBrackets(String expn) throws InvalidExpressionException 
	{
		Stack<Character> stkChar = new Stack<>();
		
		for(int i = 0; i < expn.length(); i++)
		{
			if(expn.charAt(i) == '(')
				stkChar.push(expn.charAt(i));
			
			if(expn.charAt(i) == ')')
				stkChar.pop();
		}
		
		if(!stkChar.empty())
			throw new InvalidExpressionException("Uneven brackets!!!!!!!!!");
	}
}
