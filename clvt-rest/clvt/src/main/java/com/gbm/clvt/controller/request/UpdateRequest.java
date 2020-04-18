package com.gbm.clvt.controller.request;

import java.io.Serializable;
import java.util.List;

import com.gbm.clvt.model.TextBlock;

import lombok.Data;

@Data
public class UpdateRequest implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private String name;
  private String newName;
  private String subName;
  private List<TextBlock> description;
  private String mainImage;
  private List<String> images;
  private Double price;
  private Integer discount;

}