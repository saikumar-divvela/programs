public class CD  extends ComponentDecorator{

	Computer computer;
	
	public CD(Computer c)
	{
		computer=c;
	}
	@Override
	public String description() {
		// TODO Auto-generated method stub
		System.out.println(" in CD");
		return  computer.description() + " and a CD";
	}
	
	

}