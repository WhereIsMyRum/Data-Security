package rmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
	public void queue() throws RemoteException, SecurityException;
	public void print(String A, String B) throws RemoteException, SecurityException;
}
