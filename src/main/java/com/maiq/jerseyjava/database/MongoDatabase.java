package com.maiq.jerseyjava.database;

import com.mongodb.Block;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import org.bson.Document;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Updates.inc;

public class MongoDatabase {
	
	
	//@SuppressWarnings("unchecked")
	public static void main(String args[]) {
	
	@SuppressWarnings("resource")
	MongoClient mongoClient = new MongoClient("localhost", 27017);
	com.mongodb.client.MongoDatabase database = mongoClient.getDatabase("JerseyJava");
	MongoCollection<Document> collection = database.getCollection("message");
	
	//DB db = (DB) mongoClient.getDatabase("JerseyJava");
    //DBCollection collection = db.getCollection("messages");
    
    //BasicDBObject doc = new BasicDBObject();
    //doc.put("user_id", "1");
	
	Document doc = new Document("name", "MongoDB")
            .append("type", "database")
            .append("count", 1)
            .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
            .append("info", new Document("x", 203).append("y", 102));
	
	
	collection.insertOne(doc);
	
	List<Document> documents = new ArrayList<Document>();
	
	Document doc1 = new Document("name", "MongoDB")
            .append("type", "database")
            .append("count", 1)
            .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
            .append("info", new Document("x", 203).append("y", 102));
	
	Document doc2 = new Document("name", "MongoDB")
            .append("type", "database")
            .append("count", 1)
            .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
            .append("info", new Document("x", 203).append("y", 102));
	
	Document doc3 = new Document("name", "MongoDB")
            .append("type", "database")
            .append("count", 1)
            .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
            .append("info", new Document("x", 203).append("y", 102));
	
	Document doc4 = new Document("name", "MongoDB")
            .append("type", "database")
            .append("count", 1)
            .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
            .append("info", new Document("x", 203).append("y", 102));
	
	documents.add(doc1);
	documents.add(doc2);
	documents.add(doc3);
	documents.add(doc4);
	
	collection.insertMany(documents);
	
	List<Document> documentListOne = new ArrayList<Document>();
	for(int i=1; i<=100; i++) {
		
		documentListOne.add(new Document("i", i));
	}
	collection.insertMany(documentListOne);
	
	
	System.out.println(collection.count());
	
	Document myDoc = collection.find().first();
	System.out.println(myDoc.toJson());
	
	
	MongoCursor<Document> cursor = collection.find().iterator();
	try {
		
		while(cursor.hasNext()) {
			
			System.out.println(cursor.next().toJson());
		}
	}finally {
			cursor.close();
		}
	
	myDoc =  collection.find(Filters.eq("name", "MongoDB")).first();
	System.out.println(myDoc);
	
	Block<Document> printBlock = new Block<Document>() {

		@Override
		public void apply(Document doc) {
			// TODO Auto-generated method stub
			System.out.println(doc.toJson());
		}	
	};
	
	collection.find(Filters.lt("i", 5)).forEach(printBlock);
	
	collection.find(Filters.lte("i", 5)).forEach(printBlock);
	
	collection.find(Filters.gt("i", 95)).forEach(printBlock);
	
	collection.find(Filters.and(Filters.gt("i", 5), Filters.lte("i", 10))).forEach(printBlock);
	
	collection.updateOne(Filters.eq("i", 1), new Document("$set", new Document("i", 200)));
	
	UpdateResult updateResult = collection.updateMany(Filters.eq("i", 200), inc("i", 100));
	
	System.out.println(updateResult.getModifiedCount());
	
	collection.deleteOne(Filters.eq("i", 100));
	
	DeleteResult deleteResult = collection.deleteMany(Filters.gt("i", 100));
	
	System.out.println(deleteResult.getDeletedCount());
	
	collection.createIndex(new Document("i", 1));
	}
}
