package com.maiq.jerseyjava.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.maiq.jerseyjava.database.Database;
import com.maiq.jerseyjava.exceptions.DataNotFoundException;
import com.maiq.jerseyjava.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = Database.getMessages();
	
	public MessageService() {
		
		messages.put(101L, new Message(101, "Hi, its good.", "Maiq"));
		messages.put(102L, new Message(102, "Hi, its good.", "Maiq"));
		messages.put(103L, new Message(103, "Hi, its good.", "Maiq"));
		messages.put(104L, new Message(104, "Hi, its good.", "Maiq"));
		messages.put(105L, new Message(105, "Hi, its good.", "Maiq"));
		messages.put(106L, new Message(106, "Hi, its good.", "Maiq"));
	}
	
	
	
	
	public List<Message> getMessagesPaginated(int start, int size){
		
		List<Message> list = new ArrayList<Message>(messages.values());
		if(start+size > messages.size()) {
			
			return new ArrayList<Message>();
		}
		return list.subList(start, size);
	}
	
	
	public List<Message> getAllMessagesForYear(int year){
		
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()) {
			
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	
	public List<Message> getAllMessages(){
		
		//Message m1 = new Message(101L, "Hi, let me do it", "Maiq");
		//Message m2 = new Message(102L, "Hi, let me do it again", "Ashutosh");
		
		//List<Message> list = new ArrayList<Message>();
		
		//list.add(m1);
		//list.add(m2);
		return new ArrayList<Message>(messages.values());
			
	}
	
	public Message getMessage(long id) {
		
		Message message = messages.get(id);
		if(message == null) {
			
			throw new DataNotFoundException("Message with id "+id+" not found.");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		
		if(message.getId() <=0 ) {
			
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message deleteMessage(long id) {
		
		return messages.remove(id);
	}

}
