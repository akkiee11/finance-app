package com.example.finanaceapp.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Holding {

  private String stock;
  private double buyValue;
  private double sellValue;
  private double holdValue;
  private double profit;
  private String status;

}
