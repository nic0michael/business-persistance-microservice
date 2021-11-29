package za.co.business.dtos;

public class AuthenticationRequest {
	String userIdHash;
	String passwordHash;
	
	public String getUserIdHash() {
		return userIdHash;
	}
	public void setUserIdHash(String userIdHash) {
		this.userIdHash = userIdHash;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	@Override
	public String toString() {
		return "AuthenticationRequest [userIdHash=" + userIdHash + ", passwordHash=" + passwordHash + "]";
	}
	
	

}
