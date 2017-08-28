package com.maiq.jerseyjava.service;

import java.util.List;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.maiq.jerseyjava.model.MongoMessage;
import com.mongodb.MongoClient;

public class MongoMessageService {
	
	private static final String DB_NAME = "MongoMessageDB";
	private static final String MESSAGE_COLLECTION = "messages";
	private static final String MONGO_HOST = "localhost";
	private static final int MONGO_PORT = 27017;
	
	MongoClient mongoClient = new MongoClient(MONGO_HOST, MONGO_PORT);
	MongoOperations mongoOps = new MongoTemplate(mongoClient, DB_NAME);
	
	//private List<MongoMessage> messages = MongoMessageDatabase.getMessages();
	
	public MongoMessageService() {
			
		//DB db = (DB) mongoClient.getDatabase("JerseyJava");
		//DBCollection collection = db.getCollection("messages");
		    
		//BasicDBObject doc = new BasicDBObject();
		//doc.put("user_id", "1");
		
		MongoMessage mongoMessageOne = new MongoMessage(1, "Hi, its easy.", "Mohammad");
		MongoMessage mongoMessageTwo = new MongoMessage(2, "Hi, its easy.", "Mohammad");
		MongoMessage mongoMessageThree = new MongoMessage(3, "Hi, its easy.", "Mohammad");
		MongoMessage mongoMessageFour = new MongoMessage(4, "Hi, its easy.", "Mohammad");
		MongoMessage mongoMessageFive = new MongoMessage(5, "Hi, its easy.", "Mohammad");
		
		mongoOps.insert(mongoMessageOne, MESSAGE_COLLECTION);
		mongoOps.insert(mongoMessageTwo, MESSAGE_COLLECTION);
		mongoOps.insert(mongoMessageThree, MESSAGE_COLLECTION);
		mongoOps.insert(mongoMessageFour, MESSAGE_COLLECTION);
		mongoOps.insert(mongoMessageFive, MESSAGE_COLLECTION);

		MongoMessage mongoMessage = mongoOps.findOne(new Query(Criteria.where("id").is(1)), MongoMessage.class, MESSAGE_COLLECTION);

		System.out.println(mongoMessage);
		
		//mongoOps.dropCollection(PERSON_COLLECTION);
		//mongoClient.close();
		
		
		//List<MongoMessage.class> docs = new ArrayList<MongoMessage.class>();
		
		/*DBObject docOne = createDBObject(mongoMessageOne);
		DBObject docTwo = createDBObject(mongoMessageTwo);
		DBObject docThree = createDBObject(mongoMessageThree);
		DBObject docFour = createDBObject(mongoMessageFour);
		DBObject docFive = createDBObject(mongoMessageFive);*/
		
		/*List<MongoMessage> docs = new ArrayList<MongoMessage>();
		docs.add(mongoMessageOne);
		docs.add(mongoMessageTwo);
		docs.add(mongoMessageThree);
		docs.add(mongoMessageFour);
		docs.add(mongoMessageFive);*/
		
		//List<DBObject> documents = new ArrayList<DBObject>();
		
		/*
		Document doc1 = new Document("_id", 1)
	            .append("message", "Hi, its easy.")
	            .append("created", new Date())
	            .append("author", "Mohammad");
		Document doc2 = new Document("_id", 2)
	            .append("message", "Hi, its easy.")
	            .append("created", new Date())
	            .append("author", "Mohammad");
		Document doc3 = new Document("_id", 3)
	            .append("message", "Hi, its easy.")
	            .append("created", new Date())
	            .append("author", "Mohammad");
		Document doc4 = new Document("_id", 4)
	            .append("message", "Hi, its easy.")
	            .append("created", new Date())
	            .append("author", "Mohammad");
		Document doc5 = new Document("_id", 5)
	            .append("message", "Hi, its easy.")
	            .append("created", new Date())
	            .append("author", "Mohammad");*/
		
		/*documents.add(docOne);
		documents.add(docTwo);
		documents.add(docThree);
		documents.add(docFour);
		documents.add(docFive);*/
		
		/*collection.insertMany((List<? extends Document>) documents);*/
	}


	/*public static DBObject createDBObject(MongoMessage mongoMessage) {
		
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("_id", mongoMessage.getId());
		docBuilder.append("message", mongoMessage.getMessage());
		docBuilder.append("created", mongoMessage.getCreated());
		docBuilder.append("author", mongoMessage.getAuthor());
		return docBuilder.get();
	}*/
	
	
			
	/*public List<Document> getMessagesPaginated(int start, int size){
		
		@SuppressWarnings("unchecked")
		List<Document> list = new ArrayList<Document>((Collection<? extends Document>) collection.find());
		if(start+size > list.size()) {
			
			return new ArrayList<Document>();
		}
		return list.subList(start, size);
	}*/
	
	/*
	public List<Document> getAllMessagesForYear(int year){
		
		List<Document> messagesForYear = new ArrayList<Document>();
		Calendar cal = Calendar.getInstance();
		for(Document message : documents) {
			
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}*/
	
	
	public List<MongoMessage> getAllMessages(){
		
		//Message m1 = new Message(101L, "Hi, let me do it", "Maiq");
		//Message m2 = new Message(102L, "Hi, let me do it again", "Ashutosh");
		
		//List<Message> list = new ArrayList<Message>();
		
		//list.add(m1);
		//list.add(m2);
		List<MongoMessage> mongoMessageList  = mongoOps.find(new Query(Criteria.where("author").is("Mohammad")), MongoMessage.class, MESSAGE_COLLECTION);
		return mongoMessageList;
		}
	
	public MongoMessage getMessage(long id) {
		
		//Document doc = messages.get((int) id);
		/*if(message == null) {
			
			throw new DataNotFoundException("Message with id "+id+" not found.");
		}*/
		
		MongoMessage mongoMessage = mongoOps.findOne(new Query(Criteria.where("id").is(id)), MongoMessage.class, MESSAGE_COLLECTION);
		return mongoMessage;
	}
	
	/*public MongoMessage addMessage(MongoMessage message) {
		
		message.setId(messages.size()+1);
		messages.add(message);
		return message;
	}
	
	public MongoMessage updateMessage(MongoMessage message) {
		
		if(message.getId() <=0 ) {
			
			return null;
		}
		
		messages.add(message);
		return message;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean deleteMessage(long id) {
		
		return messages.remove(id);
	}*/

}
