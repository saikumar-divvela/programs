public class OuterClass
{
	int x;
	static class Inner
	{
		void foo(){
			x=5;
		}
	}
}