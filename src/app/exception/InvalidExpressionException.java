package app.exception;

@SuppressWarnings("serial")
public class InvalidExpressionException extends Exception 
{
	public InvalidExpressionException(String message) 
	{
		super(message);
	}
}
