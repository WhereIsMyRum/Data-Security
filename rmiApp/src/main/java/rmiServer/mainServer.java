package rmiServer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class mainServer {
	public static void main(String[] args) throws NotBoundException, FileNotFoundException, IOException {
		Registry registry = LocateRegistry.createRegistry(5099);
		registry.rebind("rmiServer", new ServerImpl(60000));
		
		ServerInterface printer = (ServerInterface) Naming.lookup("rmi://localhost:5099/rmiServer");
		System.out.println("Printer server up and running");
		
		Registry loginRegistry = LocateRegistry.createRegistry(5098);
		loginRegistry.rebind("loginServer", new LoginImpl(printer));
		System.out.println("Login server up and running");
	}
}
