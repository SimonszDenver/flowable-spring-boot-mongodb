package com.objectone.mongodbservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.DBObject;
import com.objectone.mongodbservice.dto.DataDto;

public interface DataService {
    DataDto save(JsonNode jsonNode);

    DBObject get(String id);
}
