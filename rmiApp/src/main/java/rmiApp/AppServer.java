package rmiApp;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppServer {
	public static void main(String[] args) throws RemoteException {
		Registry registry = LocateRegistry.createRegistry(5099);
		registry.rebind("rmi", new Servant());
	}
}
