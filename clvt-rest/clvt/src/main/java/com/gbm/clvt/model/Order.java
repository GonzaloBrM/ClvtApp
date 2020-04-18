package com.gbm.clvt.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gbm.clvt.util.ProductUtil;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("orders")
public class Order {

  @Id
  private String id;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dateCreated;

  private List<ProductOrder> products = new ArrayList<ProductOrder>();

  public Double getTotalPrice() {
    return ProductUtil.getTotalPrice(products);
  }
}