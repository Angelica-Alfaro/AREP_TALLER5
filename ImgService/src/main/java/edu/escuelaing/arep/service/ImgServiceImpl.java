package edu.escuelaing.arep.service;

import spark.Request;
import spark.Response;

/**
 * Class that obtains the resources of the service to for the valid user
 * @author Angélica
 */
public class ImgServiceImpl {

	/**
	* Method that obtains the resource
	* @param req - request with required credentials
	* @param res - HTTP response
	* @return resource of image type
	*/
	public String getImage(Request req, Response res) {
		String image = "<img src=\"https://www.cinepremiere.com.mx/wp-content/uploads/2021/07/Caricaturas-2000s-Destacada-900x506.png\"> ";
		return image;
	}
	
	/**
	* Method that obtains the resource
	* @param req - request with required credentials
	* @param res - HTTP response
	* @return resource of image type
	*/
	public String getSecondImage(Request req, Response res) {
		String image = "<img src=\"https://wolkenmagazine.com/wp-content/uploads/2020/04/Portadas-Blog-Caricaturas_Mesa-de-trabajo-1-780x405.jpg\"> ";
		return image;
	}
}
