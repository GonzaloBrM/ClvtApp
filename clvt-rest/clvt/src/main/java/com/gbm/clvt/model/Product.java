package com.gbm.clvt.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import lombok.Data;

@Data
@Document(collection = "products")
public class Product implements Serializable {

  private static final long serialVersionUID = 6410629466039634146L;

  @JsonIgnore
  @Id
  @NotNull
  // Unique Id
  private String id;

  @NotNull
  // Name of the product
  private String name;

  // Subname of the product
  private String subName;

  @NotNull
  // Description of the product
  private List<TextBlock> description;

  // The image url
  private String mainImage;

  // The images
  private List<String> images;

  @NotNull
  // The price
  private Double price;

  // The discount
  private Integer discount;

  // Map of stock by size and color
  private Map<String, Map<String, Integer>> stock;

  public Double getFinalPrice() {

    // Check var nulls
    if (price == null && discount == null)
      return null;
    price = price == null ? 0.0 : price;
    discount = discount == null ? 0 : discount;

    // Calculate
    Double discountFactor = (100.0 - discount) / 100.0;
    return price * discountFactor;
  }

  @JsonIgnore
  public Set<String> getColors() {
    return stock.keySet();
  }

  @JsonIgnore
  public Map<String, Integer> getColor(String color) {
    Map<String, Integer> response = stock.get(color);
    return response == null ? new HashMap<String, Integer>() : response;
  }

  @JsonIgnore
  public Map<String, Integer> addColor(@Nullable String color) {
    color = color == null ? "None" : color;

    if (!stock.containsKey(color)) {
      return stock.put(color, new HashMap<String, Integer>());
    }
    return stock.get(color);
  }

  @JsonIgnore
  public Map<String, Integer> addSize(@Nullable String color, String... size) {
    Map<String, Integer> stockBySize = addColor(color);
    Arrays.asList(size).forEach((s) -> {
      stockBySize.put(s, 0);
    });
    return stockBySize;
  }

  public void addStock(@Nullable String color, String size, Integer stock) {
    Integer stockVal = addColor(color).get(size);
    stockVal = stockVal == null ? 0 : stockVal;
    stock = stock == null ? 0 : stock;
    addColor(color).put(size, stockVal + stock);
  }

  @JsonIgnore
  public Map<String, Integer> removeSize(@Nullable String color, String... size) {
    Map<String, Integer> stockBySize = getColor(color);

    Arrays.asList(size).forEach((s) -> {
      stockBySize.remove(s);
    });
    return stockBySize;
  }

}