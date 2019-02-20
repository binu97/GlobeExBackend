package com.dao.examples;

import com.google.gson.Gson;
import com.model.Destination;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class InsertingDocument {

    public static void main( String args[] ) {

        // Creating a Mongo client
        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "myDb",
                "password".toCharArray());
        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("myDb");

        // Retrieving a collection
//        MongoCollection<Document> collection = database.getCollection("sampleCollection");
        System.out.println("Collection sampleCollection selected successfully");

        Destination destination = new Destination();
        destination.setName("Ruwanweliseya");
        destination.setDescription("sads adsd saddsa ddsd sd dasdss ");
        destination.setTown("Anuradhapura");


        Gson gson = new Gson();
        MongoCollection<Document> collection = database.getCollection("myDb");
        Document document = Document.parse(gson.toJson(destination));
        collection.insertOne(document);
    }
}