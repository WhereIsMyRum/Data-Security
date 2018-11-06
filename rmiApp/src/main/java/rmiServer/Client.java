package rmiServer;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import rmiServer.ServerInterface;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, SecurityException, InvalidUserException, InterruptedException, NoSuchAlgorithmException {
		
		String username = "Piotrek";
		String password = "Siusiak";
		
		String hashedPassword = getHash(password);
		
		LoginInterface loginService = (LoginInterface) Naming.lookup("rmi://localhost:5098/loginServer");
		
		ServerInterface printerService = (ServerInterface) loginService.login(username, hashedPassword);
	
		printerService.queue();
		printerService.queue();
	}
	
	private static String getHash(String password) throws NoSuchAlgorithmException
	{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(encodedhash);
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}
