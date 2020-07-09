package com.objectone.flowablespringboot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.objectone.flowablespringboot.dto.DataDto;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class FlowableServiceImpl implements FlowableService {

    @Autowired
    private DataService dataService;

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public String initializeVariables(JsonNode json) {
        DataDto dataDto = dataService.saveJson(json);

        Map<String, Object> values = new HashMap<>();
        values.put("id", dataDto.getId());

        ProcessInstance instance = runtimeService.startProcessInstanceByKey("CamelVariableTransmission", values);
        log.info("process instance: {}", instance.getProcessInstanceId());
        return instance.getProcessInstanceId();
    }
}
