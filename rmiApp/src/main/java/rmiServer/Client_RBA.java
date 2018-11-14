package rmiServer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.security.auth.Subject;

import rmiServer.PrinterInterface;

public class Client_RBA {
	public static void main(String[] args) throws NotBoundException, SecurityException, InvalidUserException, InterruptedException, NoSuchAlgorithmException, FileNotFoundException, IOException {
		
		
		
		String token = null;
		String username = "David";
		String password = "Password123";
		PrinterInterface printer = (PrinterInterface) Naming.lookup("rmi://localhost:5099/printerServer");
		token = printer.login(username, password);
		
		printer.queue(token);
	}
}