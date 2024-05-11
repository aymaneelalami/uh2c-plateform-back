package com.uh2plateform.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter @Setter
public class ComponentProperties {
    private String title;
    private String env;
    private String version;
    private Map<String, Object> metadata;

}
