package com.services;

import com.dao.MongoDBConnection;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.Iterator;


import static com.mongodb.client.model.Filters.eq;

public class SearchService {

    MongoDBConnection mongoDBConnection = new MongoDBConnection();

    public String getDestinationsForSearch(String name){

        MongoCollection<Document> collection = mongoDBConnection.getMongoCollectionByName("myDb");

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("description",  java.util.regex.Pattern.compile(name));
        FindIterable<Document> iterDoc = collection.find(basicDBObject);
//
        String jsonStr = mongoDBConnection.mongoDBDocumentsToJSON(iterDoc);
        return jsonStr;
    }
}
