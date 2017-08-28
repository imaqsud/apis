package com.maiq.jerseyjava.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.maiq.jerseyjava.model.Message;
import com.maiq.jerseyjava.resources.beans.MessageFilterBean;
import com.maiq.jerseyjava.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class MessageResource {
	
	MessageService messageService = new MessageService();

	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(/*@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size*/
			@BeanParam MessageFilterBean filterBean) {
		
		if(filterBean.getYear() > 0) {
			
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		
		if(filterBean.getStart() >= 0 && filterBean.getSize() >= 0) {
			
			return messageService.getMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	
	@GET
	@Path("/{messageId}")
	//@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id) {
		
		return messageService.getMessage(id);
	}
	
	
	@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException{
		
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
	}
	
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	
	@DELETE
	@Path("/{messageId}")
	//@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id) {
		
		messageService.deleteMessage(id);
		
		//System.out.println("Got delete");
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		
		return new CommentResource();
	}
	
}
