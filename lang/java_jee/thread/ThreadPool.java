/*

Intro
--In case of many short lived tasks thread pooling is useful. 
-- Threads are created in the begining. all go to wait state  until a task is assigned to them 
--A single thread from the pool can be recycled over and over for different tasks
--Response time improves as for each request a new thread is not created. already created
thread takes over the job

design considerations
--Thread pooling works only if the tasks are short lived ex: HTTP servlet handling a file download
--for tasks that take more time normal threads are sufficient
--if more thread are created than required efficieny decreases. based on utilization of thread pool size has to be estimated
-- rejection rate should be minimum due to unavailability of thread in pool
-- if task is waiting for a thread to takeover the job then response time hits badly
-- tasks causes deadlock. big problem if threads leave the pool and not return 

*/

import java.util.*;


public class ThreadPool
{
	private ObjectFIFO idleWorkers;
	private ThreadPoolWorker[] workers;
	
	public ThreadPool(int numOfThreads)
	{
		idleWorkers = new ObjectFIFO(numOfThreads);
		workers = new ThreadPoolWorker[numOfThreads];
		for(int i=0;i<numOfThreads;i++)
		{
			workers[i]= new ThreadPoolWorker(idleWorkers);
		}
	}
	
	public void execute(Runnable r)
	{
		System.out.println("hello");
		ThreadPoolWorker worker = (ThreadPoolWorker) idleWorkers.remove();
		worker.process(r);
	}
	
	public static void main(String args[])
	{
		System.out.println("Hello World!!!");
		ThreadPool threadPool = new ThreadPool(3);
		Runnable ra = makeRunnable("Worker A",2000);
		threadPool.execute(ra);
		Runnable rb = makeRunnable("Worker B",3000);
		threadPool.execute(rb);
		Runnable rc = makeRunnable("Worker C",1000);
		threadPool.execute(rc);
		Runnable rd = makeRunnable("Worker D",1000);
		threadPool.execute(rd);
		Runnable re = makeRunnable("Worker E",3000);
		threadPool.execute(re);
	}
	
	public static Runnable makeRunnable(
				final String name,
				final long firstDelay
			){
				return new Runnable(){
					public void run() {
						try 
						{
							System.out.println(name+" starting up");
							Thread.sleep(firstDelay);
							System.out.println(name+" doing some stuff");
							Thread.sleep(2000);
							System.out.println(name+" leaving");
						} catch(InterruptedException iexp){
							System.out.println(name+" Interrupted");
							return ;
						}
						catch(Exception exp )
						{
							System.out.println(name+" exception :"+exp.getMessage());
						}
						
					}
				};
	}
	
}

class ThreadPoolWorker
{
		private static int nextWorkerId;
		int workerId;
		private ObjectFIFO idleWorkers; 
		private ObjectFIFO handOffBox;
		private Thread internalThread;
		public ThreadPoolWorker(ObjectFIFO idleWorkers)
		{
			this.idleWorkers = idleWorkers;
			workerId = getNextWorkerId();
			handOffBox = new ObjectFIFO(1);
			Runnable r = new Runnable(){
								public void run(){
									try 
									{
										runWork();
									} catch(Exception exp)
									{
										System.out.println(exp.getMessage());
									}
								}
						};
			internalThread = new Thread(r) ;
			internalThread.start();
		}
		private static int getNextWorkerId(){
			return ++nextWorkerId;
		}
		
		public void process(Runnable r)
		{
			System.out.println("adding the object to handOffBox");
			handOffBox.add(r);
		}
		
		public void runWork()
		{
			while(true)
			{
				try {
					System.out.println("workerId "+workerId+" ready for work");
					idleWorkers.add(this);
					System.out.println("workerId almost ready");
					Runnable r =  (Runnable) handOffBox.remove();
					System.out.println("workerId "+workerId+" starting execution of new Runnable");
					runIt(r);
				} /* catch(InterruptedException e){
					System.out.println("runWork Exception occurred:"+e.getMessage());
					Thread.currentThread().interrupt();
				} */catch(Exception exp){
					System.out.println("runWork Exception occurred:"+exp.getMessage());
				}
				
			}
		}
		
		public void runIt(Runnable r)
		{
			try {
				r.run();
			} catch (Exception exp)
			{
				System.out.println("runIt Exception occurred:"+exp.getMessage());
			} finally {
				Thread.interrupted();
			}
		}
}
class ObjectFIFO
{
	int size;
	ArrayList objects;
	public ObjectFIFO(int size)
	{
		this.size = size;
		objects = new ArrayList(size);
	}
	
	public synchronized void add(Object o){
		System.out.println("addig thread to ildeWorkers");
		System.out.println(objects.size());
		if(objects.size() < size)
		{
			
			System.out.println("done");
			objects.add(o);
		}
	}
	
	public synchronized Object remove()
	{
		Object obj = null;
		while(objects.isEmpty()){
		}
		obj = objects.get(0);
		objects.remove(0);
		return obj;
	}
	
	public synchronized Object[] removeAll()
	{
		Object[] objArray = null;
		int i =0;
		while(!objects.isEmpty())
		{
			objArray[i++] = objects.get(0);
			objects.remove(0);
		}
		return objArray;
	}
}
