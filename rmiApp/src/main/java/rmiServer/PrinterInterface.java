package rmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

import javax.security.auth.Subject;

public interface PrinterInterface extends Remote {
	
	public void print(String filename, String printer, String token) throws RemoteException, SecurityException, InterruptedException;   // prints file filename on the specified printer
	public void queue(String token) throws RemoteException, SecurityException;   // lists the print queue on the user's display in lines of the form <job number>   <file name>
	public void topQueue(int job, String token) throws RemoteException, SecurityException;   // moves job to the top of the queue
	public void start(String token) throws RemoteException, SecurityException;   // starts the print server
	public void stop(String token) throws RemoteException, SecurityException;   // stops the print server
	public void restart(String token) throws RemoteException, SecurityException;   // stops the print server, clears the print queue and starts the print server again
	public void status(String token) throws RemoteException, SecurityException;  // prints status of printer on the user's display
	public void readConfig(String parameter, String token) throws RemoteException, SecurityException;   // prints the value of the parameter on the user's display
	public void setConfig(String parameter, String value, String token) throws RemoteException, SecurityException;   // sets the parameter to value
	
	public String login(String username, String password) throws RemoteException, SecurityException, InvalidUserException, NoSuchAlgorithmException;

}
