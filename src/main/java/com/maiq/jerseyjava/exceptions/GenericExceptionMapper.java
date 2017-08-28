package com.maiq.jerseyjava.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.maiq.jerseyjava.model.ErrorMessage;


@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exp) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage = new ErrorMessage(exp.getMessage(), 500, "http://errordoc.com/doc");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}
	
}
