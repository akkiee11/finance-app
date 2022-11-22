package com.example.finanaceapp.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IdealPortfolioRecommendation {

  Double percentage;
  String stock;
  String stockType;

}
