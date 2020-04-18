package com.gbm.clvt.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "configuration")
public class InitialConfiguration {

  @Id
  @JsonIgnore
  private String id;
  private List<String> sections;
  private AboutConfiguration about;
  private List<TextBlock> generalProductInfo;
  private String footer;
  private String previous;
  private String next;
}