package com.services;

import com.dao.MongoDBConnection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class DestinationService {

    MongoDBConnection mongoDBConnection = new MongoDBConnection();

    public String getDestinationsByName(String name){
        MongoCollection<Document> collection = mongoDBConnection.getMongoCollectionByName("myDb");
        FindIterable<Document> iterDoc = collection.find(eq("name", name));
        String jsonStr = mongoDBConnection.mongoDBDocumentsToJSON(iterDoc);
        return jsonStr;
    }

    public String getDestinationsByTown(String town){
        MongoCollection<Document> collection = mongoDBConnection.getMongoCollectionByName("myDb");
        FindIterable<Document> iterDoc = collection.find(eq("town", town));
        String jsonStr = mongoDBConnection.mongoDBDocumentsToJSON(iterDoc);
        return jsonStr;
    }
}
