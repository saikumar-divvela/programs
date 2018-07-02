public class ClassA extends ClassB
{
	boolean b=false;
	private ClassC cc;

	public static void main(String[] args)
	{
		ClassA a = new ClassA();
		a.invokeToCallbackHere();
	}

	/**
	 * Callback function from ClassC
	 */
	public void value()
	{
		System.out.println("b is: "+b);
	}

	@Override
	public void initState()
	{
		letsChangeOrNot();
	}

	private void letsChangeOrNot()
	{

		cc = new ClassC(this);
		b = true;

	}

	private void invokeToCallbackHere()
	{
		cc.letsCheck();
	}
}



abstract class ClassB
{
	public ClassB()
	{
		initState();
	}

	public abstract void initState();

}

class ClassC
{
	private ClassA a;

	public ClassC(ClassA a)
	{
	 this.a = a;
	}

	public void letsCheck()
	{
		a.value();
	}
}