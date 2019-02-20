package com.dao;

import com.mongodb.BasicDBList;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.Iterator;
import java.util.List;

public class MongoDBConnection {

    public MongoCollection<Document> getMongoCollectionByName(String collectionName){
        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "myDb",
                "password".toCharArray());
        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("myDb");

        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection(collectionName);

        return collection;
    }


    public String mongoDBDocumentsToJSON(FindIterable<Document> iterDoc){
        int i = 1;

        Iterator iterator = iterDoc.iterator();

        BasicDBList list = new BasicDBList();
        while (iterator.hasNext()) {
            Document doc = (Document) iterator.next();
            list.add(doc);
        }
        System.out.println(JSON.serialize(list));
        return JSON.serialize(list);
    }
}
