package com.timesbakeshop.system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cake {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "cakes")
    private List<Order> orders;

}
