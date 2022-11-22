package com.example.finanaceapp.utils;

import com.example.finanaceapp.model.Holding;
import com.example.finanaceapp.model.Trade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TradeUtils {

  public static List<Holding> getHoldingsFromTrades(List<Trade> trades) {
    List<Holding> holdings = new ArrayList<>();
    trades.stream().collect(Collectors.groupingBy(Trade::getStock)).forEach((stock, stockTrades) -> {
      double buyValue = 0.0;
      double sellValue = 0.0;
      double holdValue = 0.0;
      for (Trade trade : stockTrades) {
        double value = trade.getPrice() * trade.getQuantity();
        if ("BUY".equals(trade.getPosition())) {
          buyValue += value;
          holdValue += trade.getQuantity();
        } else {
          sellValue += value;
          holdValue -= trade.getQuantity();
        }
      }
      double profit = holdValue == 0 ? sellValue - buyValue : 0;
      String status = holdValue != 0 ? "OPEN" : "CLOSED";
      Holding holding = Holding.builder().stock(stock).buyValue(buyValue).sellValue(sellValue).profit(profit)
        .holdValue(holdValue).status(status).build();
      holdings.add(holding);
    });
    return holdings;
  }

}
