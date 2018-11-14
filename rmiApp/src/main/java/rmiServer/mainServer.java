package rmiServer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

public class mainServer {
	public static void main(String[] args) throws NotBoundException, FileNotFoundException, IOException {
		try{
			Registry registry = LocateRegistry.createRegistry(5099);
			//registry.rebind("printerServer", new PrinterImpl_PolicyFile());
			registry.rebind("printerServer", new PrinterImpl_RBA());
			System.out.println("Server started!");
		} catch(ExportException e)
		{
			System.out.println("Server is already running");
		}
		
	}
}
