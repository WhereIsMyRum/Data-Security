package rmiApp;

import java.rmi.Remote;

public interface RemoteServiceProvider extends Remote{
	boolean check(String authCode);
}
