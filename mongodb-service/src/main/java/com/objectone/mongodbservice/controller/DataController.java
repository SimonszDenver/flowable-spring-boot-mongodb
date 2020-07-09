package com.objectone.mongodbservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.DBObject;
import com.objectone.mongodbservice.dto.DataDto;
import com.objectone.mongodbservice.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
@Slf4j
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/save")
    public ResponseEntity<DataDto> save(@RequestBody JsonNode jsonNode){
        log.info("HIT /data/save | POST | Json Node : {}", jsonNode);
        return new ResponseEntity<>(dataService.save(jsonNode), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DBObject> get(@PathVariable String id){
        log.info("HIT /data/{id} | GET | ID : {}", id);
        return new ResponseEntity<>(dataService.get(id), HttpStatus.OK);
    }
}
