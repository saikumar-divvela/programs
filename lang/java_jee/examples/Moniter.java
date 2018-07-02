public class Moniter extends ComponentDecorator{
		Computer computer;
		
		public Moniter (Computer c)
		{
			computer=c;
		}
		@Override
		public String description() {
			// TODO Auto-generated method stub
			return  computer.description() + " and a Moniter ";
		}
}
