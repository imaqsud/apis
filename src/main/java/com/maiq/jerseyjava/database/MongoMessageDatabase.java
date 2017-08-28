package com.maiq.jerseyjava.database;

import com.maiq.jerseyjava.model.MongoMessage;

import java.util.ArrayList;
import java.util.List;

public class MongoMessageDatabase {
	
	private static List<MongoMessage> messages = new ArrayList<MongoMessage>();
	
	public static List<MongoMessage> getMessages() {
		
		return messages;
	}
	
}
