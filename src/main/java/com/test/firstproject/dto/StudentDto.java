package com.test.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String name;
    private String emailAddress;
    private String gender;
    private String phoneNumber;
    private String level;
}

//ModelMapper
/*<dependency>
<groupId>org.modelmapper</groupId>
<artifactId>modelmapper</artifactId>
<version>3.2.0</version>
</dependency>*/

