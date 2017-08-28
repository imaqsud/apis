package com.maiq.jerseyjava.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String injectDemo(@MatrixParam("param") String matrixParam, @HeaderParam("oAuthKey") String header, @CookieParam("cookie") String cookieParam) {
		
		return matrixParam+" "+header+" "+cookieParam;
	}
	
	@GET
	@Path("context")
	public String getParamsByContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		
		String absolutePath = uriInfo.getAbsolutePath().toString();
		String cookie = headers.getCookies().toString();
		return absolutePath+"\n"+cookie;
	}
}
