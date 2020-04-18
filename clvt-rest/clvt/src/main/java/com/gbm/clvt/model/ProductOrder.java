package com.gbm.clvt.model;

import com.gbm.clvt.util.ProductUtil;

import lombok.Data;

@Data
public class ProductOrder {

  private Product product;
  private Integer size;
  private Integer color;
  private Integer quantity;

}