package com.objectone.flowablespringboot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.objectone.flowablespringboot.dto.DataDto;

public interface DataService {
    DataDto saveJson(JsonNode json);

    JsonNode getJson(String id);
}
