package jannesh;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	
	private String name;
	private String uname;
	private String pword;
	
	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}
	
	public String toString() {
		return name+" "+" | "+uname;
	}

}
