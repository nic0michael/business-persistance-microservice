package za.co.business.dtos;

public class AuthenticationResponse {
	String responseCode;
	String responseMessage;
	String userIdHash;
	String passwordHash;
	String role;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "AuthenticationResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage
				+ ", userIdHash=" + userIdHash + ", passwordHash=" + passwordHash + ", role=" + role + "]";
	}
	
	

}
