package rmiServer;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.security.auth.Subject;

public class ServerProxy implements ServerInterface, Serializable {
	Subject user;
	ServerInterface myServer;
	
	public ServerProxy(Subject user, ServerInterface myServer)
	{
		this.user = user;
		this.myServer = myServer;
	}
	
	public void queue() throws RemoteException, SecurityException {
		myServer.queue();
	}

	public void print(String A, String B) throws RemoteException, SecurityException {
		myServer.print(A, B);
	}

}
