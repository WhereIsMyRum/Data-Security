package rmiServer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

public interface PrinterInterface extends Remote {
	
	public void print(String filename, String printer, String token) throws RemoteException, SecurityException;
	public void queue(String token) throws RemoteException, SecurityException;   
	public void topQueue(int job, String token) throws RemoteException, SecurityException;   
	public void start(String token) throws RemoteException, SecurityException;   
	public void stop(String token) throws RemoteException, SecurityException;  
	public void restart(String token) throws RemoteException, SecurityException;   
	public void status(String token) throws RemoteException, SecurityException;  
	public void readConfig(String parameter, String token) throws RemoteException, SecurityException;   
	public void setConfig(String parameter, String value, String token) throws RemoteException, SecurityException;   
	public String login(String username, String password) throws RemoteException, SecurityException, InvalidUserException, NoSuchAlgorithmException, FileNotFoundException, IOException;
}
