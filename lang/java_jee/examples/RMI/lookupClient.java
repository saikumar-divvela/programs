import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.Naming;

public class lookupClient
{
	public static void main(String args[]){
		try
		{
			System.setProperty("java.security.policy", "C:/Saikumar/programs/java_j2ee/RMI/rmi.policy");
			if(System.getSecurityManager()==null) 	System.setSecurityManager(new RMISecurityManager());
			String name ="rmi://localhost/lookupserver";
			lookup look_obj = (lookup) Naming.lookup(name);
			String result = look_obj.getMessage();
			if(result == null ){
				System.out.println("***Not Found***");
			} else {
				System.out.println("Result:"+result);
			}
		}
		catch (Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
}