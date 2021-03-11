package practice.interview.questions;

/**
 * 
 * @author amol
 *
 */
public class CustomExceptionPractice {
	public static void main(String[] args) throws CustomException {
		throw new CustomException("error occured");
	}
}

class CustomException extends Exception
{
	public CustomException(String error) {
		// TODO Auto-generated constructor stub
		super(error);
	}
}
