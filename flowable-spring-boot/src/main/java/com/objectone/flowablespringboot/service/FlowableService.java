package com.objectone.flowablespringboot.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface FlowableService {
    String initializeVariables(JsonNode json);
}
