package rmiServer;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;

public class PrinterImpl_RBA extends UnicastRemoteObject implements PrinterInterface{

	private HashMap<String, String> user_token_map = new HashMap<String,String>();
	private String secretStuff = "Some secret stuff";
	
	protected PrinterImpl_RBA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void print(String filename, String printer, String token) throws RemoteException, SecurityException {
		
		System.out.println("Print:");
		try {
			if (checkRole(token, new String[]{"admin","superuser","user"} )){
				System.out.println("print method invoked");
			}
			else {
				System.out.println("You do not have necessary permission!");
			}
		}catch(ExpiredJwtException e)
		{
			System.out.println("Token expired! Log in again.");
		}catch(SignatureException e)
		{
			System.out.println("Signature does not match!");
		}catch(MalformedJwtException e)
		{
			System.out.println("Token incorrect!");
		}
	}
	
	public void queue(String token) throws RemoteException, SecurityException {
		System.out.println("Queue:");
		try {
			if (checkRole(token, new String[]{"admin","superuser","user"} )){
				System.out.println("queue method invoked");
			}
			else {
				System.out.println("You do not have necessary permission!");
			}
		}catch(ExpiredJwtException e)
		{
			System.out.println("Token expired! Log in again.");
		}catch(SignatureException e)
		{
			System.out.println("Signature does not match!");
		}catch(MalformedJwtException e)
		{
			System.out.println("Token incorrect!");
		}
	}

	public void topQueue(int job, String token) throws RemoteException, SecurityException {
		System.out.println("topQueue:");
		try {
			if (checkRole(token, new String[]{"admin","superuser"} )){
				System.out.println("topQueue method invoked");
			}
			else {
				System.out.println("You do not have necessary permission!");
			}
		}catch(ExpiredJwtException e)
		{
			System.out.println("Token expired! Log in again.");
		}catch(SignatureException e)
		{
			System.out.println("Signature does not match!");
		}catch(MalformedJwtException e)
		{
			System.out.println("Token incorrect!");
		}
	}

	public void start(String token) throws RemoteException, SecurityException {
		System.out.println("start:");
		try {
			if (checkRole(token, new String[]{"admin","janitor"} )){
				System.out.println("start method invoked");
			}
			else {
				System.out.println("You do not have necessary permission!");
			}
		}catch(ExpiredJwtException e)
		{
			System.out.println("Token expired! Log in again.");
		}catch(SignatureException e)
		{
			System.out.println("Signature does not match!");
		}catch(MalformedJwtException e)
		{
			System.out.println("Token incorrect!");
		}
	}

	public void stop(String token) throws RemoteException, SecurityException {
		System.out.println("stop:");
		try {
			if (checkRole(token, new String[]{"admin","janitor"} )){
				System.out.println("stop method invoked");
			}
			else {
				System.out.println("You do not have necessary permission!");
			}
		}catch(ExpiredJwtException e)
		{
			System.out.println("Token expired! Log in again.");
		}catch(SignatureException e)
		{
			System.out.println("Signature does not match!");
		}catch(MalformedJwtException e)
		{
			System.out.println("Token incorrect!");
		}
	}

	public void restart(String token) throws RemoteException, SecurityException {
		System.out.println("restart:");
		try {
			if (checkRole(token, new String[]{"admin","janitor","superuser"} )){
				System.out.println("restart method invoked");
			}
			else {
				System.out.println("You do not have necessary permission!");
			}
		}catch(ExpiredJwtException e)
		{
			System.out.println("Token expired! Log in again.");
		}catch(SignatureException e)
		{
			System.out.println("Signature does not match!");
		}catch(MalformedJwtException e)
		{
			System.out.println("Token incorrect!");
		}
	}

	public void status(String token) throws RemoteException, SecurityException {
		System.out.println("status:");
		try {
			if (checkRole(token, new String[]{"admin","janitor"} )){
				System.out.println("status method invoked");
			}
			else {
				System.out.println("You do not have necessary permission!");
			}
		}catch(ExpiredJwtException e)
		{
			System.out.println("Token expired! Log in again.");
		}catch(SignatureException e)
		{
			System.out.println("Signature does not match!");
		}catch(MalformedJwtException e)
		{
			System.out.println("Token incorrect!");
		}
	}

	public void readConfig(String parameter, String token) throws RemoteException, SecurityException {
		System.out.println("readConfig:");
		try {
			if (checkRole(token, new String[]{"admin","janitor"} )){
				System.out.println("readConfig method invoked");
			}
			else {
				System.out.println("You do not have necessary permission!");
			}
		}catch(ExpiredJwtException e)
		{
			System.out.println("Token expired! Log in again.");
		}catch(SignatureException e)
		{
			System.out.println("Signature does not match!");
		}catch(MalformedJwtException e)
		{
			System.out.println("Token incorrect!");
		}
	}

	public void setConfig(String parameter, String value, String token) throws RemoteException, SecurityException {
		System.out.println("setConfig:");
		try {
			if (checkRole(token, new String[]{"admin","janitor"} )) {
				System.out.println("setConfig method invoked");
			}
			else {
				System.out.println("You do not have necessary permission!");
			}
		}catch(ExpiredJwtException e)
		{
			System.out.println("Token expired! Log in again.");
		}catch(SignatureException e)
		{
			System.out.println("Signature does not match!");
		}catch(MalformedJwtException e)
		{
			System.out.println("Token incorrect!");
		}
		
	}

	public String login(String username, String password) throws SecurityException, InvalidUserException, NoSuchAlgorithmException, FileNotFoundException, IOException {
		System.out.println("Invoking methods as "+username);
		String realPassword = null;
		String userSalt = null;
		Properties passwords = new Properties();
		try {
			
			String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			passwords.load(new FileInputStream(rootPath + Constants.PASS_FILENAME));
			realPassword = passwords.getProperty(username);
			userSalt = passwords.getProperty(username + "_salt");
			//System.out.println(password + " " + userSalt + " " + getHash(password + userSalt));
		} catch (IOException e) {
			throw new InvalidUserException("Something went wrong");
		}
		
		if ((realPassword == null) || !realPassword.equals(getHash(password + userSalt))) {
			throw new InvalidUserException("Wrong username or password!");
		}

		// check if token was issued
		if(user_token_map.containsKey(username))
		{
			if(validateToken(user_token_map.get(username))){
				//token exists and has not expired
				System.out.println("Token alread exists. Returning already issued token...");
				return user_token_map.get(username);
			}
			else {
				//token already exists, but has expired
				user_token_map.remove(username);
			}
		}
		//issue a new token
		System.out.println("Generating new token...");
		String token = createJWT(900000, username, passwords.getProperty(username + "_role"));
		user_token_map.put(username, token);
		return token;
	}

	private String createJWT(long expiration, String issuer, String role) throws FileNotFoundException, IOException {

		//The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		//We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretStuff);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		
		//Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder()
				.setIssuedAt(now)
				.setIssuer(issuer)
				.claim("role", role)
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

	private boolean validateToken(String token){
		try {
		Claims claims = Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(secretStuff))
				.parseClaimsJws(token).getBody();
		
		}catch(ExpiredJwtException e)
		{
			System.out.println("Token expired! Log in again.");
			return false;
		}catch(SignatureException e)
		{
			System.out.println("Signature does not match!");
			return false;
		}catch(MalformedJwtException e)
		{
			System.out.println("Token incorrect!");
			return false;
		}
		
		return true;
	}
	
	private boolean checkRole(String token, String[] roles) {
		Claims claims = Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(secretStuff))
				.parseClaimsJws(token).getBody();
		
		for (String role : roles) {
			if (claims.get("role").equals(role)) return true;
		}
		
		return false;
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
