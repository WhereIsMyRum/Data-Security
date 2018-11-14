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

public class Client_PolicyFile {
	public static void main(String[] args) throws NotBoundException, SecurityException, InvalidUserException, InterruptedException, NoSuchAlgorithmException, FileNotFoundException, IOException {
		
/* Users' access:
 * Alice - all operations
 * Bob - start, stop, restart, status, readConfig, setConfig
 * Cecilia - print, queue, topQueue, restart
 * David, Erica, Fred, George - print, queue
 * Users' changes:
 * Bob leaves, George comes insted
 * Henry - print, queue
 * Ida - print, queue, topQueue, restart
 */
		
		//String username = "Jacek";
		//String password = "Data_security_project_1";
		
		
		
		String token = null;
		/*try {
			token = printer.login(username, password);
		} catch(InvalidUserException e) {
			System.out.println(e.getMessage());
		}
		/*token = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NDIyMTYzMTUsImlzcyI6Ikdlb3JnZSIsInByaW50IjoidHJ1ZSIsInF1ZXVlIjoidHJ1ZSIsInRvcFF1ZXVlIjoiZmFsc2UiLCJzdGFydCI6ImZhbHNlIiwic3RvcCI6ImZhbHNlIiwicmVzdGFydCI6ImZhbHNlIiwic3RhdHVzIjoiZmFsc2UiLCJyZWFkQ29uZmlnIjoiZmFsc2UiLCJzZXRDb25maWciOiJmYWxzZSIsImV4cCI6MTU0MjIxNzIxNX0.BCLbHbwqQ8a-Wi4YXPrVZjZgMeLLSasiGmetPUgxcyE";
		
		if(token != null) {
			try {
				printer.start(token);
			}catch (IllegalArgumentException e) {
				System.out.println("The token is empty!");
			}
		}*/
		
		String username = "Alice";
		String password = "Password123";
		PrinterInterface printer = (PrinterInterface) Naming.lookup("rmi://localhost:5099/printerServer");
		token = printer.login(username, password);
		Thread.sleep(2000);
		printer.print("filename","printer",token);
		Thread.sleep(2000);
		printer.queue(token);
		Thread.sleep(2000);
		printer.topQueue(1, token);
		Thread.sleep(2000);
		printer.start(token);
		Thread.sleep(2000);
		printer.stop(token);
		Thread.sleep(2000);
		printer.restart(token);
		Thread.sleep(2000);
		printer.status(token);
		Thread.sleep(2000);
		printer.readConfig("parameter", token);
		Thread.sleep(2000);
		printer.setConfig("parameter", "value", token);
		Thread.sleep(2000);
		
		username = "Bob";
		password = "Password123";
		token = printer.login(username, password);
		Thread.sleep(2000);
		printer.print("filename","printer",token);
		Thread.sleep(2000);
		printer.queue(token);
		Thread.sleep(2000);
		printer.topQueue(1, token);
		Thread.sleep(2000);
		printer.start(token);
		Thread.sleep(2000);
		printer.stop(token);
		Thread.sleep(2000);
		printer.restart(token);
		Thread.sleep(2000);
		printer.status(token);
		Thread.sleep(2000);
		printer.readConfig("parameter", token);
		Thread.sleep(2000);
		printer.setConfig("parameter", "value", token);
		Thread.sleep(2000);
		
		username = "Cecilia";
		password = "Password123";
		token = printer.login(username, password);
		Thread.sleep(2000);
		printer.print("filename","printer",token);
		Thread.sleep(2000);
		printer.queue(token);
		Thread.sleep(2000);
		printer.topQueue(1, token);
		Thread.sleep(2000);
		printer.start(token);
		Thread.sleep(2000);
		printer.stop(token);
		Thread.sleep(2000);
		printer.restart(token);
		Thread.sleep(2000);
		printer.status(token);
		Thread.sleep(2000);
		printer.readConfig("parameter", token);
		Thread.sleep(2000);
		printer.setConfig("parameter", "value", token);
		Thread.sleep(2000);
		
		username = "David";
		password = "Password123";
		token = printer.login(username, password);
		Thread.sleep(2000);
		printer.print("filename","printer",token);
		Thread.sleep(2000);
		printer.queue(token);
		Thread.sleep(2000);
		printer.topQueue(1, token);
		Thread.sleep(2000);
		printer.start(token);
		Thread.sleep(2000);
		printer.stop(token);
		Thread.sleep(2000);
		printer.restart(token);
		Thread.sleep(2000);
		printer.status(token);
		Thread.sleep(2000);
		printer.readConfig("parameter", token);
		Thread.sleep(2000);
		printer.setConfig("parameter", "value", token);
		Thread.sleep(2000);
		
		username = "Erica";
		password = "Password123";
		token = printer.login(username, password);
		Thread.sleep(2000);
		printer.print("filename","printer",token);
		Thread.sleep(2000);
		printer.queue(token);
		Thread.sleep(2000);
		printer.topQueue(1, token);
		Thread.sleep(2000);
		printer.start(token);
		Thread.sleep(2000);
		printer.stop(token);
		Thread.sleep(2000);
		printer.restart(token);
		Thread.sleep(2000);
		printer.status(token);
		Thread.sleep(2000);
		printer.readConfig("parameter", token);
		Thread.sleep(2000);
		printer.setConfig("parameter", "value", token);
		Thread.sleep(2000);
		
		username = "Fred";
		password = "Password123";
		token = printer.login(username, password);
		Thread.sleep(2000);
		printer.print("filename","printer",token);
		Thread.sleep(2000);
		printer.queue(token);
		Thread.sleep(2000);
		printer.topQueue(1, token);
		Thread.sleep(2000);
		printer.start(token);
		Thread.sleep(2000);
		printer.stop(token);
		Thread.sleep(2000);
		printer.restart(token);
		Thread.sleep(2000);
		printer.status(token);
		Thread.sleep(2000);
		printer.readConfig("parameter", token);
		Thread.sleep(2000);
		printer.setConfig("parameter", "value", token);
		Thread.sleep(2000);
		
		username = "George";
		password = "Password123";
		token = printer.login(username, password);
		Thread.sleep(2000);
		printer.print("filename","printer",token);
		Thread.sleep(2000);
		printer.queue(token);
		Thread.sleep(2000);
		printer.topQueue(1, token);
		Thread.sleep(2000);
		printer.start(token);
		Thread.sleep(2000);
		printer.stop(token);
		Thread.sleep(2000);
		printer.restart(token);
		Thread.sleep(2000);
		printer.status(token);
		Thread.sleep(2000);
		printer.readConfig("parameter", token);
		Thread.sleep(2000);
		printer.setConfig("parameter", "value", token);
		Thread.sleep(2000);
		
		
	}
	
}
