package com.maiq.jerseyjava.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.maiq.jerseyjava.model.MongoMessage;
import com.maiq.jerseyjava.service.MongoMessageService;

@Path("/mongomessages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class MongoMessageResource {
	
	MongoMessageService messageService = new MongoMessageService();

	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	public List<MongoMessage> getMessages() {
		
		/*if(filterBean.getYear() > 0) {
			
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		
		if(filterBean.getStart() >= 0 && filterBean.getSize() >= 0) {
			
			return messageService.getMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}*/
		
		return messageService.getAllMessages();
	}
	
	
	@GET
	@Path("/{messageId}")
	//@Produces(MediaType.APPLICATION_JSON)
	public MongoMessage getMessage(@PathParam("messageId") long id) {
		
		return messageService.getMessage(id);
	}
	
	
	/*@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(MongoMessage message, @Context UriInfo uriInfo) throws URISyntaxException{
		
		MongoMessage newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
	}
	
	
	@PUT
	@Path("/{messageId}")
	public MongoMessage updateMessage(@PathParam("messageId") long id, MongoMessage message) {
		
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	
	@DELETE
	@Path("/{messageId}")
	//@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id) {
		
		messageService.deleteMessage(id);
		
		//System.out.println("Got delete");
	}*/
	
	/*@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		
		return new CommentResource();
	}*/
	
}
