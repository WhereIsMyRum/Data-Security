package rmiServer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;


import javax.security.auth.Subject;

public class LoginImpl extends UnicastRemoteObject implements LoginInterface {

	private ServerInterface myServer;
	
	public LoginImpl(ServerInterface theServer) throws FileNotFoundException, IOException {
		myServer = theServer;
	}

	public ServerInterface login(String username, String password) throws RemoteException, SecurityException, InvalidUserException {
		Subject user = new Subject();
		user.getPrincipals().add(new RMILoginPrincipal(username));
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
		
		
		return new ServerProxy(user, myServer);
	}

}
