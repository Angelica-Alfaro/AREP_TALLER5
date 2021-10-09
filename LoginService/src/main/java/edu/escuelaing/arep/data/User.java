package edu.escuelaing.arep.data;

/** 
 * Class that defines the attributes of a user
 * @author Angélica
 */
public class User {
	private String email;
	private String password;

	/**
	 * Constructor of an User
	 * @param email
	 * @param password
	 */
	public User(String email, String password) {
		this.email = email;
		this.password = HashEncryption.encryptPassword(password);
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email to change
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password to change
	 */
	public void setPassword(String password) {
		this.password = password;
	}


}
