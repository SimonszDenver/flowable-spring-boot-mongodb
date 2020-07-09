package com.objectone.flowablespringboot.camel;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

import java.util.Map;

public class SaveOutput implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
//        Map<String, String> outputMap = (Map<String, String>) execution.getVariable("outputMap");
//        outputMap.put("outputValue", (String) execution.getVariable("camelBody"));
        System.out.println("Save Output");
    }
}
