package com.timesbakeshop.system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String customerName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime pickUpDate;

    @ManyToMany
    private List<Cake> cakes;
    private String description;
    private Status status;

    public Order(String customerName, LocalDateTime createdDate, LocalDateTime pickUpDate, List<Cake> cakes,
                 String description) {
        this.customerName = customerName;
        this.createdDate = createdDate;
        this.pickUpDate = pickUpDate;
        this.cakes = cakes;
        this.description = description;
    }

    enum Status {
        CREATED("Order received"),
        PARTIALLY_PAID("Partial payment has been given, balance to be settled upon claiming"),
        FULLY_PAID("Order is fully paid"),
        FULFILLED("Items ordered are ready for pick-up"),
        RELEASED("Order has been claimed by customer"),
        CANCELLED("Order was cancelled");

        private String description;

        Status(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

}
