package com.test.firstproject.model;

import lombok.*;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@ToString
@Builder
public class Project {
    private String name;
    private String domain;
    private Double duration;
    private Double budget;
}
