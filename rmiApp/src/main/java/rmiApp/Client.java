package rmiApp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		RemoteService service = (RemoteService) Naming.lookup("rmi://localhost:5099/rmi");
		service.print("TestingFile", "MyPrinter");
		service.queue();
	}
}
