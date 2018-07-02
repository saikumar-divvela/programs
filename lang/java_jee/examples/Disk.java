
public class Disk  extends ComponentDecorator{
	
	Computer computer;
	
	public Disk(Computer  c){
		computer =c;
		
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		System.out.println("inside disk");
		return computer.description() + " and a disk";
	}
}