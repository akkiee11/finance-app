package com.example.finanaceapp.dao;

import com.example.finanaceapp.model.Trade;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class TradeRepository {
    List<Trade> trades = new ArrayList<>();

    public boolean createTrade(Trade trade) {
        trades.add(trade);
        return true;
    }

    public Trade findTradeById(Integer id) {
        for (Trade trade : trades) {
            if (trade.getId() == id) {
                return trade;
            }
        }
        return null;
    }

    public boolean updateTradeById(Trade trade) {
        for (Trade existingTrade : trades) {
            if (existingTrade.getId() == trade.getId()) {
                trades.remove(existingTrade);
                trades.add(trade);
                break;
            }
        }
        return true;
    }

    public boolean deleteTradeById(Integer id) {
        return trades.removeIf(trade -> trade.getId() == id);

    }

    public List<Trade> getTradesByEmail(String email) {
        List<Trade> tradeList = new ArrayList<>();
        for (Trade trade : trades) {
            if (Objects.equals(trade.getEmail(), email)) {
                tradeList.add(trade);
            }
        }
        return tradeList;
    }
}
