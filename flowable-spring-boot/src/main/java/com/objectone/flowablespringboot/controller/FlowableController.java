package com.objectone.flowablespringboot.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.objectone.flowablespringboot.service.FlowableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flowable")
public class FlowableController {

    @Autowired
    private FlowableService flowableService;

    @PostMapping("/initialize")
    public ResponseEntity<String> initializeVariables(@RequestBody JsonNode json){
        return new ResponseEntity<>(flowableService.initializeVariables(json), HttpStatus.OK);
    }
}
