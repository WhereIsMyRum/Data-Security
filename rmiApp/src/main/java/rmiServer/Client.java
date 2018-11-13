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
		String password = "I_am_a_your_password_Luke";
		
		//String username = "Jacek";
		//String password = "Data_security_project_1";
		
		
		PrinterInterface printer = (PrinterInterface) Naming.lookup("rmi://localhost:5099/printerServer");
		String token = null;
		try {
			token = printer.login(username, password);
		} catch(InvalidUserException e) {
			System.out.println(e.getMessage());
		}
		
		if(token != null) {
			try {
				printer.queue(token);
			}catch (IllegalArgumentException e) {
				System.out.println("The token is empty!");
			}
		}
		
		
		
	}
	
}
