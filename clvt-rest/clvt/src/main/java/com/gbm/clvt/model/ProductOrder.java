package com.gbm.clvt.model;

import lombok.Data;

@Data
public class ProductOrder {

  private Product product;
  private Integer size;
  private Integer color;
  private Integer quantity;

}