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
		registry.rebind("printerServer", new PrinterImpl());
		
		
	}
}
