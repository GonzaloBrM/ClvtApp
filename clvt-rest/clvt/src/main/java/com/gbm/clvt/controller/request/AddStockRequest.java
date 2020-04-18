package com.gbm.clvt.controller.request;

import lombok.Data;

@Data
public class AddStockRequest {

  private String productName;
  private String color;
  private String size;
  private Integer stock;

}