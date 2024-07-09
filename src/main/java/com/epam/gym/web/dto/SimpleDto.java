package com.epam.gym.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonDeserialize(builder = SimpleDto.SimpleDtoBuilder.class)
public class SimpleDto {
    private String name;
    private Long age;
    private List<String> lang;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SimpleDtoBuilder {
    }
}
