package com.objectone.mongodbservice.repository;

import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;


public interface DataRepository extends CrudRepository<DBObject, ObjectId> {
}
