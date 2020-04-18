package com.gbm.clvt.model;

import java.util.List;

import lombok.Data;

@Data
public class TextBlock {
  private String title;
  private List<String> paragraphs;

}