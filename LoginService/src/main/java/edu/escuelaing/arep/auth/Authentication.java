package edu.escuelaing.arep.auth;

import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.arep.data.User;

/**
 * Class that handles the authentication of a user to access a resource.
 * @author Angélica
 */
public class Authentication {

	private static Map<String, String> users = new HashMap<>();
	
	/**
	 * Constructor of authentication
	 */
	public Authentication() {
		createValidUser();
	}
	
	/**
	 * Method that creates a valid user
	 */
	private void createValidUser() {
		String email = "angelica-prueba@gmail.com";
		String password = "12345";

		User user = new User(email, password);
		users.put(user.getEmail(), user.getPassword());
	}
	
	/**
	 * Method to verify if the user is valid to access the service
	 * @param user - A user with his credentials
	 * @return if it is a valid user
	 */
	public boolean validCredentials(User user) {
		boolean isValid = false;
		if (users.containsKey(user.getEmail())){
			if (users.get(user.getEmail()).equals(user.getPassword())) {
				isValid = true;
			}
		}
		return isValid;
	}
}
