package edu.escuelaing.arep;

import static spark.Spark.*;

import edu.escuelaing.arep.connection.URLReader;
import edu.escuelaing.arep.controller.LoginServiceController;
import edu.escuelaing.arep.service.LoginServiceImpl;

/**
 * Communication  using java network management libraries.
 * @author Angélica
 *
 */
public class App {
	
	/**
	 * Start the web server
	 * @param args - server connection
	 */
	public static void main(String[] args) {
		port(getPort());
		staticFiles.location("/public");
		//API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null);
        URLReader.initContext();
		new LoginServiceController(new LoginServiceImpl()); 
	}

	/**
	 * This method reads the default port as specified by the PORT variable in the
	 * environment.
	 *
	 * Provides the port so you need this to run the project.
	 */
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; 
	}
}