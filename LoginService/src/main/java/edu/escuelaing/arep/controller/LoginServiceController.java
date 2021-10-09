package edu.escuelaing.arep.controller;

import static spark.Spark.get;
import static spark.Spark.post;
import edu.escuelaing.arep.service.LoginServiceImpl;

/**
 * Class that manages service endpoints.
 * @author Angélica
 */
public class LoginServiceController {
	
	/**
	 * Method that handles the authentication of the login service
	 * @param myLoginServiceImpl - service to manage
	 */
	public LoginServiceController(LoginServiceImpl myLoginServiceImpl) {
		get("/hello", (req,res) -> "Hello security!");
		post("/login", (req, res) -> myLoginServiceImpl.login(req, res));
	}
}
