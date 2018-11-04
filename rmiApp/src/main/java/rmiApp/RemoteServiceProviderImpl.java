package rmiApp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServiceProviderImpl implements RemoteServiceProvider{
	private static Registry remoteService;
	
	public RemoteServiceProviderImpl() throws RemoteException {
		remoteService = LocateRegistry.createRegistry(5099);
		remoteService.rebind("rmi", new Servant());
	}
	
	
	RemoteService getService(String authCode) throws RemoteException {
		if (check(authCode)) return (RemoteService) UnicastRemoteObject.exportObject(remoteService, 6000);
		
		else throw new RemoteException("Authentication failed");
	}

	public boolean check(String authCode) {
			if (authCode == "AAA") return true;
			else return false;
	}
}
