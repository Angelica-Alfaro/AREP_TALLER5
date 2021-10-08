package edu.escuelaing.arep.service;

import spark.Request;
import spark.Response;
import com.google.gson.Gson;

import edu.escuelaing.arep.auth.Authentication;
import edu.escuelaing.arep.connection.URLReader;
import edu.escuelaing.arep.data.User;

/**
 * Class that handles the authorization records of a user
 *
 * @author Angélica
 */
public class LoginServiceImpl {
	
	private static final Gson gson = new Gson();
	private final String URL = "https://localhost:4600/img";
	private static final Authentication auth = new Authentication();

	/**
	* Method that allows access to a valid user
	* @param req - request with required credentials
	* @param res - HTTP response
	* @return Denial or access to the service
	*/
	public String auth(Request req, Response res) {
		System.out.println("Auth login :)");
		
		String result = "";
        User user = gson.fromJson(req.body(), User.class);
        if(auth.validCredentials(user)) {
        	result = URLReader.readURL(URL);
		}
        else {
			result = "Invalid credentials!";
		}
		return result;
	}

}
