package com.gbm.clvt.service;

import java.util.List;

import com.gbm.clvt.model.Order;

public interface OrderService {

  public List<Order> getAll();

  public Order create(Order order);

  public Order update(Order order);

}