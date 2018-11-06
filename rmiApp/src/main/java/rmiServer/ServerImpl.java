package rmiServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface { 

	public ServerImpl(int port) throws RemoteException {
		super(port);
	}
	public void queue() throws RemoteException, SecurityException {
		System.out.println("Queue executed");
		
	}

	public void print(String A, String B) throws RemoteException, SecurityException {
		System.out.println("Print executed");
	}

}
