package com.gbm.clvt.model;

import java.util.List;

import lombok.Data;

@Data
public class AboutConfiguration {
  private String image;
  private String title;
  private String subtitle;
  private List<String> paragraphs;

}