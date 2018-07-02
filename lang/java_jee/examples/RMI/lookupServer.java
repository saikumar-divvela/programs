import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class lookupServer extends UnicastRemoteObject implements lookup
{
	public lookupServer() throws RemoteException{

	}
	public String getMessage(){
		return "hello";
	}
	public static void main (String args[]){
		try
		{
			System.setProperty("java.security.policy", "C:/Saikumar/programs/java_j2ee/RMI/rmi.policy");
			if(System.getSecurityManager()==null) 	System.setSecurityManager(new RMISecurityManager());
			lookupServer server = new lookupServer();
			Naming.rebind("lookupserver",server);
			System.err.println("lookupServer is ready");
		}
		catch (Exception exp)
		{
			System.err.println("exception: "+exp);
			System.exit(1);
		}
	}
}  