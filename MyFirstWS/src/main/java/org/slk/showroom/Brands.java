package org.slk.showroom;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

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
		return "Add a new brand ";
	}
	@PUT
	@Path("/putBrands/{branchid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String putBrands(@PathParam("branchid") int branch)
	{
		return "update a new brand"+branch;
	}
	@DELETE
	@Path("/deleteBrands/{branchid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBrands(@PathParam("branchid") int branch)
	{
		return "delete a new brand "+branch;
	}
	
}
