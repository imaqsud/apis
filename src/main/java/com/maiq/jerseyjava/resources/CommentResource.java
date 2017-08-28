package com.maiq.jerseyjava.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.maiq.jerseyjava.model.Comment;
import com.maiq.jerseyjava.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService commentService= new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId){
		
		return commentService.getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long cId) {
		
		return commentService.getComment(messageId, cId);
	}
	
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		
		return commentService.addComment(messageId, comment);
	}
	
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long mId, @PathParam("commentId") long cId, Comment comment) {
		
		comment.setId(cId);
		return commentService.updateComment(mId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long mId, @PathParam("commentId") long cId) {
		
		commentService.deleteComment(mId, cId);
	}
}
