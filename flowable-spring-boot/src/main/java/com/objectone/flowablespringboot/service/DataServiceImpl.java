package com.objectone.flowablespringboot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.objectone.flowablespringboot.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public DataDto saveJson(JsonNode json) {
        HttpEntity<Object> entity = new HttpEntity<>(json, getHttpHeaders());
        ResponseEntity<DataDto> dataDto = restTemplate.exchange("http://127.0.0.1:7000/data/save", HttpMethod.POST, entity, DataDto.class);
        return dataDto.getBody();
    }

    @Override
    public JsonNode getJson(String id) {
        HttpEntity<Object> entity = new HttpEntity<>(getHttpHeaders());
        ResponseEntity<JsonNode> json = restTemplate.exchange("http://127.0.0.1:7000/data/"+id, HttpMethod.GET, entity, JsonNode.class);
        return json.getBody();
    }


    private HttpHeaders getHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        return httpHeaders;
    }
}
