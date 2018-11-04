package rmiApp;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppServer {
	public static void main(String[] args) throws RemoteException {
		
		RemoteServiceProviderImpl serviceProvider = new RemoteServiceProviderImpl();
		
		
	}
}
