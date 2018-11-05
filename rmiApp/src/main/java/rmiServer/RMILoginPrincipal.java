package rmiServer;

import java.io.Serializable;
import java.security.Principal;

public class RMILoginPrincipal implements Principal, Serializable{

	private String username;
	public RMILoginPrincipal(String username)
	{
		this.username = username;
	}
	public String getName() {
		return username;
	}
	
}
