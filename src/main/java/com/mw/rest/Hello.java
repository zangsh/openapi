package com.mw.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(){
		return "Hello World";
	}
}
