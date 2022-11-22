package com.example.finanaceapp.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class Trade {

  private int id;
  private String stock;
  private Date timestamp;
  private String email;
  private double price;
  private double quantity;
  private String position;
}
