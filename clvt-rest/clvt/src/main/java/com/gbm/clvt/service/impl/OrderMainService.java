package com.gbm.clvt.service.impl;

import java.util.List;

import com.gbm.clvt.model.Order;
import com.gbm.clvt.repository.OrderRepository;
import com.gbm.clvt.service.OrderService;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;

public class OrderMainService implements OrderService {

  @AutoConfigureOrder
  private OrderRepository repository;

  @Override
  public List<Order> getAll() {
    return repository.findAll();
  }

  @Override
  public Order create(Order order) {
    return repository.insert(order);
  }

  @Override
  public Order update(Order order) {
    return repository.save(order);
  }

}