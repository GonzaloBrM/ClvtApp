package com.gbm.clvt.controller;

import java.util.List;

import com.gbm.clvt.model.Order;
import com.gbm.clvt.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("order")
public class OrderController {

  @Autowired
  private OrderService service;

  @GetMapping("/getAll")
  public List<Order> getAll() {
    return service.getAll();
  }

  @PostMapping("/add")
  Order add(@RequestBody Order request) {
    return service.create(request);
  }
}