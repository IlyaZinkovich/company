package com.epam.company.dao.impl;

import com.epam.company.dao.LoggingDAO;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoggingDAOImpl implements LoggingDAO {

    @Autowired
    private MongoCollection collection;

    @Override
    public void logMessage(String message) {
        collection.insertOne(new Document().append("message", message));
    }

}
