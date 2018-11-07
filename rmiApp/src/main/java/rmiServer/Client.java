package rmiServer;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.security.auth.Subject;

import rmiServer.PrinterInterface;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, SecurityException, InvalidUserException, InterruptedException, NoSuchAlgorithmException {
		
		String username = "Piotrek";
		String password = "Siusiak";
		
		
		PrinterInterface printer = (PrinterInterface) Naming.lookup("rmi://localhost:5099/printerServer");
		
		String token = printer.login(username, password);
		//String token = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NDE2MTkzODcsImlzcyI6IlBpb3RsZWsiLCJleHAiOjE1NDE2MjAyODd9.0P9n4ljEG_Vsgkj5BGI_MCz8JRL2FC-oVvK38EVPtu0";
		
		printer.print("Chuj","dupa",token);
	
		//Subject user = new Subject();
		//user.getPrincipals().add(new RMILoginPrincipal(username,"agh"));
		//System.out.println(username);
		//printerService.print("raz","dwa", user);
	}
	
}
