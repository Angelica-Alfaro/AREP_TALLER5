package edu.escuelaing.arep.controller;

import static spark.Spark.get;
import edu.escuelaing.arep.service.ImgServiceImpl;

/**
 * Class that manages service endpoints.
 * @author Angélica
 */
public class ImgServiceController {
	
	/**
	 * Method that obtains the resources of the service
	 * @param myImgServiceImpl - service to manage
	 */
	public ImgServiceController(ImgServiceImpl myImgServiceImpl) {
		get("/hello", (req,res) -> "Hello security!");
		get("/img", (req, res) -> myImgServiceImpl.getSecondImage(req, res));
	}
}
