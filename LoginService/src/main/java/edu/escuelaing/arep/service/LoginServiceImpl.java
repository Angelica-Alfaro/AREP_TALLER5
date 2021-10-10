package edu.escuelaing.arep.service;

import spark.Request;
import spark.Response;

import java.util.ArrayList;

import com.google.gson.Gson;

import edu.escuelaing.arep.auth.Authentication;
import edu.escuelaing.arep.connection.URLReader;
import edu.escuelaing.arep.data.User;

/**
 * Class that handles the authorization records of a user.
 * @author Angélica
 */
public class LoginServiceImpl {
	
	private static final Gson gson = new Gson();
	//private final String URL = "https://localhost:4600/img";
	private final String URL = "https://ec2-54-167-98-62.compute-1.amazonaws.com:4600/img";
	private static final Authentication auth = new Authentication();

	/**
	* Method that allows access to a valid user
	* @param req - request with required credentials
	* @param res - HTTP response
	* @return Denial or access to the service
	*/
	public String login(Request req, Response res) {
		ArrayList<String> myParams = getParams(req.body());

		String result = "";
        User user = new User(myParams.get(0), myParams.get(1));
        if(auth.validCredentials(user)) {
        	result = URLReader.readURL(URL);
		}
        else {
			result = "Credenciales inválidas :(";
		}
		return result;
	}
	
	/**
	* Method that obtains the credentials entered by the user
	* @param body - credentials sent by the form
	* @return list with email value and password
	*/
	public ArrayList<String> getParams(String body) {
		ArrayList<String> params = new ArrayList<>();
	    for (String s : body.split("&")) {
	        String[] kv = s.split("=");
	        params.add(kv[1]);
	    }
	    return params;
	}
}
