class BadFoodException extends Exception
{
	public BadFoodException(){
		super("food is not good");
	}
	public BadFoodException(String msg){
		super(msg);
	}
}

public class MyException
{
	public static void main(String args[]){
		try{
			checkFood(args[0]);
		} catch(BadFoodException bexp){
			System.out.println("bad food :"+bexp.getMessage());
		}

	}
	private static void checkFood(String food) throws BadFoodException{
		if(food.equals("pesarattu")){
				throw new BadFoodException();
		} else {
			System.out.println("food is good");
		}

	}
}