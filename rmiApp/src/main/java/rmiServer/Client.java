package rmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmiServer.ServerInterface;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, SecurityException, InvalidUserException, InterruptedException {
		LoginInterface loginService = (LoginInterface) Naming.lookup("rmi://localhost:5098/loginServer");
		String username = "Piotrek";
		String password = "Siusiak";
		ServerInterface printerService = (ServerInterface) loginService.login(username, password);
	
		printerService.queue();
		Thread.sleep(10000);
		printerService.queue();
	}
}
