package com.gbm.clvt.controller.request;

import java.util.List;

import lombok.Data;

@Data
public class AddSizesRequest {
  private String productName;
  private String color;
  private List<String> sizes;

}