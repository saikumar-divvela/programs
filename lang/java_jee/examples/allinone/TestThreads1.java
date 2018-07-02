import java.util.*;
public class TestThreads1 
{
			private List names = new ArrayList();
			public synchronized void add(String name) 
			{
					names.add(name);
			}
			public synchronized void printAll() 
			{
					for (int i = 0; i <names.size(); i++) 
					{
							System.out.print(names.get(i) +" ");
					}
			}
			public static void main(String[] args) 
			{
					final TestThreads1 sl = new TestThreads1();
					for(int i=0;i<2;i++) 
					{	
						new Thread() 
							{
									public void run() 
									{
											sl.add("A");
											sl.add("B");
											sl.add("C");
											sl.printAll();
									}
							}.start();
				}
		}
}