package com.gbm.clvt.util;

import java.util.List;

import com.gbm.clvt.model.ProductOrder;

public class ProductUtil {

  public static Double getTotalPrice(List<ProductOrder> orders) {
    return orders.stream().mapToDouble(p -> p.getProduct().getFinalPrice() * p.getQuantity()).sum();
  }
}