package rmiApp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Servant extends UnicastRemoteObject implements Service{

	protected Servant() throws RemoteException {
		super();
	}

	public void print(String filename, String printer) throws RemoteException {
		System.out.println("print method invoked");
	}

	public void queue() throws RemoteException {
		System.out.println("queue method invoked");
	}

	public void topQueue(int job) throws RemoteException {
		System.out.println("topQueue method invoked");
	}

	public void start() throws RemoteException {
		System.out.println("start method invoked");
	}

	public void stop() throws RemoteException {
		System.out.println("stop method invoked");
	}

	public void restart() throws RemoteException {
		System.out.println("restart method invoked");
	}

	public void status() throws RemoteException {
		System.out.println("print method invoked");
	}

	public void readConfig(String parameter) throws RemoteException {
		System.out.println("readConfig method invoked");
		
	}

	public void setConfig(String parameter, String value) throws RemoteException {
		System.out.println("setConfig method invoked");
	}
	
}
