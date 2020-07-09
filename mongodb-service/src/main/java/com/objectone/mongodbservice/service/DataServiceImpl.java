package com.objectone.mongodbservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.objectone.mongodbservice.dto.DataDto;
import com.objectone.mongodbservice.repository.DataRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataRepository dataRepository;

    @Override
    public DataDto save(JsonNode jsonNode) {
        BasicDBObject dbObject = BasicDBObject.parse(jsonNode.toString());
        BasicDBObject object = dataRepository.save(dbObject);
        ObjectId id = (ObjectId)object.get( "_id" );
        return new DataDto(id.toString());
    }

    @Override
    public DBObject get(String id) {
        return dataRepository.findById(new ObjectId(id)).get();
    }
}
