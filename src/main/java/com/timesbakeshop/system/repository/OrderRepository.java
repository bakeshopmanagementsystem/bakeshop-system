package com.timesbakeshop.system.repository;

import com.timesbakeshop.system.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    List<Order> findAll();

}
