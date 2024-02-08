package com.test.firstproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aid;
    @NotBlank
    //@Transient
    private String type;
    private String state;
    private String city;

//    @ManyToMany(mappedBy = "addresses")
//    private Set<Student> students = new HashSet<>();
}
