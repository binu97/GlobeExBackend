package com.services;

import com.dao.MongoDBConnection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class LoginService {

    MongoDBConnection mongoDBConnection = new MongoDBConnection();

    public String getDetailsByName(String userName) {
        MongoCollection<Document> collection = mongoDBConnection.getMongoCollectionByName("Login");
        FindIterable<Document> iterDoc = collection.find(eq("UserName", userName));
        String jsonStr = mongoDBConnection.mongoDBDocumentsToJSON(iterDoc);
        return jsonStr;
    }
}
