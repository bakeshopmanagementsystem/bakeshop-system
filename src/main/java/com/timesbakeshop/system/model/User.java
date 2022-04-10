package com.timesbakeshop.system.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private String contactNum;
    private String designation;

    @Column(unique = true)
    private String username;
    private String password;
    private boolean enabled = true;

    @ManyToOne
    @JoinTable(name="USER_ROLE")
    private Role role;

}
