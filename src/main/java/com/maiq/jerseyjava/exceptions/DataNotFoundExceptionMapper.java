package com.maiq.jerseyjava.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.maiq.jerseyjava.model.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exp) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage = new ErrorMessage(exp.getMessage(), 404, "http://errordoc.com/doc");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}
	
}
