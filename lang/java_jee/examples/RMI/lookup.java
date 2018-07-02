import java.rmi.Remote;
import java.rmi.RemoteException;

public interface lookup extends Remote
{
	public String getMessage() throws RemoteException;
}