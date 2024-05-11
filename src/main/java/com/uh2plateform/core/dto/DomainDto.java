package com.uh2plateform.core.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class DomainDto {

    private String id;
    private String name;
    private String key;
    private String type;
}
