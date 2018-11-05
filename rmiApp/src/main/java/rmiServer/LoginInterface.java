package rmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginInterface extends Remote {
	public ServerInterface login(String username, String password) throws RemoteException, SecurityException, InvalidUserException;
}
