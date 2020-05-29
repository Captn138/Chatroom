package chatroom;

public class User {
	private String username;
	private String pwdsha512;
	
	public User(String username, String pwdsha512) {
		this.username = username;
		this.pwdsha512 = pwdsha512;
	}
	
	public void setUsername(String setUsername) {
		
		username = setUsername;
	}
	
	public void setPwd(String setPwd) {
		
		pwdsha512 = setPwd;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPwd() {
		return pwdsha512;
	}
}
