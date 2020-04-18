package com.gbm.clvt.controller;

import java.util.List;

import com.gbm.clvt.model.Order;
import com.gbm.clvt.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
  ResponseEntity<Order> add(@RequestBody Order request) {
    Order order = service.create(request);

    String uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/orders/{id}")
        .buildAndExpand(order.getId()).toString();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Location", uri);

    return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
  }
}