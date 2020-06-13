package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		try {
			System.out.println("Hello world");
			int i = 1/0;
			System.out.println("Complted");
	
		}
		catch (Exception exp) {
			System.out.println("I am inside the catch block"); 
			System.out.println("Message is  :" + exp.getMessage());
			System.out.println("Casued is : "+ exp.getCause());
			exp.printStackTrace();
		}
		finally {
			System.out.println("I am inside the finally block");
		}		
	}

}
