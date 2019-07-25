import javax.swing.*;

public class MyException extends Exception{

	public MyException(String s)
	{
		super(s);
	}
	public static void main(String[] args)throws MyException {
		// TODO Auto-generated method 
			try {
				throw new MyException("≥ˆœ÷“Ï≥£¿≤~");
			}
			catch(MyException e)
			{
				System.out.println(e);
			}
	}

}
