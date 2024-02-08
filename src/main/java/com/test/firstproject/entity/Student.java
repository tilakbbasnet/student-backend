package com.test.firstproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

//@Data
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sid")
    private Long id;

    @NotBlank(message = "Please provide fullname")
    private String fullName;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Length(min=4, max = 6, message = "Gender length should be between 4 and 6")
    private String gender;
    @Column(name="phone_number")
    @Length(min = 10, max = 10, message = "Phone number should have exactly 10 digits")
    private String phone;
    @NotBlank
    private String level;


    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="fk_address_id")//Default foreign key = tablename_pkey



    //@NotNull
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "student_address",
//    joinColumns = @JoinColumn(name = "student_id"),
//    inverseJoinColumns = @JoinColumn(name = "address_id"))
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_student_id", referencedColumnName = "sid")
    private List<Address> addresses;
}
