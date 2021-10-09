package edu.escuelaing.arep.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that allows to encrypt a user attribute.
 * @author Angélica
 */
public class HashEncryption {
	
	/**
	 * Method that encrypts the user's password in a SHA-256 hash
	 * @param password - user's password
	 * @return encrypted user's password
	 */
	public static String encryptPassword(String password) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(HashEncryption.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}

		byte[] hash = messageDigest.digest(password.getBytes());
		StringBuilder stringBuffer = new StringBuilder();

		for (byte b : hash) {
			stringBuffer.append(String.format("%02x", b));
		}

		return stringBuffer.toString();
	}

}
