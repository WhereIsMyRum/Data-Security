package rmiServer;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.security.auth.Subject;

public class PrinterImpl extends UnicastRemoteObject implements PrinterInterface{

	private ArrayList tokenArray = new ArrayList();
	
	protected PrinterImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void print(String filename, String printer, String token) throws RemoteException, SecurityException, InterruptedException {
		if(tokenArray.contains(token)) {
			System.out.println("dziala");
		}
		Thread.sleep(10000);
		System.out.println("Koniec");
		
	}

	public void queue(String token) throws RemoteException, SecurityException {
		// TODO Auto-generated method stub
		
	}

	public void topQueue(int job, String token) throws RemoteException, SecurityException {
		// TODO Auto-generated method stub
		
	}

	public void start(String token) throws RemoteException, SecurityException {
		// TODO Auto-generated method stub
		
	}

	public void stop(String token) throws RemoteException, SecurityException {
		// TODO Auto-generated method stub
		
	}

	public void restart(String token) throws RemoteException, SecurityException {
		// TODO Auto-generated method stub
		
	}

	public void status(String token) throws RemoteException, SecurityException {
		// TODO Auto-generated method stub
		
	}

	public void readConfig(String parameter, String token) throws RemoteException, SecurityException {
		// TODO Auto-generated method stub
		
	}

	public void setConfig(String parameter, String value, String token) throws RemoteException, SecurityException {
		// TODO Auto-generated method stub
		
	}

	public String login(String username, String password) throws RemoteException, SecurityException, InvalidUserException, NoSuchAlgorithmException {
		
		String realPassword = null;
		try {
			Properties passwords = new Properties();
			String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			passwords.load(new FileInputStream(rootPath + Constants.PASS_FILENAME));
			realPassword = passwords.getProperty(username);
		} catch (IOException e) {
			throw new InvalidUserException("Something went wrong");
		}
		
		if ((realPassword == null) || !realPassword.equals(password)) {
			throw new InvalidUserException("wrong username or password");
		}
		
		
		String tempToken = generate_token(username);
		tokenArray.add(tempToken);
		
		return tempToken;
	}
	
	private String generate_token(String username) throws NoSuchAlgorithmException {
		return getHash(username + "lubieJajca");
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
