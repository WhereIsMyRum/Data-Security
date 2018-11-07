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

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import io.jsonwebtoken.*;
import java.util.Date;

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
			System.out.println(rootPath);
			passwords.load(new FileInputStream(rootPath + Constants.PASS_FILENAME));
			realPassword = passwords.getProperty(username);
		} catch (IOException e) {
			throw new InvalidUserException("Something went wrong");
		}
		
		if ((realPassword == null) || !realPassword.equals(password)) {
			throw new InvalidUserException("wrong username or password");
		}

		//expiration time on token is 15 min
		String token = createJWT(900000, username);
		tokenArray.add(token);

		return token;
	}

	private String createJWT(long expiration, String issuer) {

		//The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		//We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("Some secret stuff");
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		//Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder()
				.setIssuedAt(now)
				.setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);

		//if it has been specified, let's add the expiration
		if (expiration >= 0) {
			long expMillis = nowMillis + expiration;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		//Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
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
