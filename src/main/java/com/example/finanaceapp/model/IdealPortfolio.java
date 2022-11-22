package com.example.finanaceapp.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdealPortfolio {

  private int id;
  private Double amount;
  private InvestorMode mode;
  private Date timestamp;
  private String email;
  private String name;
  List<IdealPortfolioRecommendation> recommendations;

}
