package org.slk.controller;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.springframework.stereotype.Controller;

@Controller
@Path("/showroom")
public class Brands 
{
	@GET
	@Path("/getBrands")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBrands()
	{
		return "list of brands";
	}
	@POST
	@Path("/setBrands")
	@Produces(MediaType.TEXT_PLAIN)
	public String setBrands()
	{
		return "Add a new brand";
	}

	
	

}
