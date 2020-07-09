package com.objectone.flowablespringboot.process;

import com.fasterxml.jackson.databind.JsonNode;
import com.objectone.flowablespringboot.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class FlowableProcess implements Processor {

    @Autowired
    private DataService dataService;

    @Override
    public void process(Exchange exchange) throws Exception {
        Map<String, Object> properties = exchange.getProperties();
        log.info((String) properties.get("id"));

        JsonNode json = dataService.getJson((String) properties.get("id"));
        log.info("Json : {}", json);
    }
}
