package com.objectone.flowablespringboot.camel;

import com.objectone.flowablespringboot.process.FlowableProcess;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AsyncPingRoute extends RouteBuilder {

    @Autowired
    private FlowableProcess flowableProcess;

    @Override
    public void configure() throws Exception {
//        from("flowable:CamelVariableTransmission:ping").transform().simple("${property.input} World This is camel route");
//        from("flowable:CamelVariableTransmission:ping").
//                to("class:com.objectone.flowablespringboot.camel.CamelTask?method=flowableTask");
        from("flowable:CamelVariableTransmission:ping?copyVariablesToProperties=true").
                process(flowableProcess);
    }

}
