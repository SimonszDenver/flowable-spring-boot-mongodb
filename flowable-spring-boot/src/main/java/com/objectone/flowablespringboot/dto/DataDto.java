package com.objectone.flowablespringboot.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class DataDto implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonCreator
    public DataDto(@JsonProperty("id") String id) { this.id = id;}
}
