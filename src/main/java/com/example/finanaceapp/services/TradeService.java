package com.example.finanaceapp.services;

import com.example.finanaceapp.dao.TradeRepository;
import com.example.finanaceapp.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public boolean createTrade(String name, Double price, Double quantity, String position, String email) {
        Trade trade = Trade.builder().stock(name).price(price).quantity(quantity).position(position).email(email).build();
        return tradeRepository.createTrade(trade);
    }

    public Trade getTradeById(Integer id) {
        return tradeRepository.findTradeById(id);
    }

    public boolean updateTradeById(Integer id, String name, Double price, Double quantity, String position) {
        Trade presentTrade = getTradeById(id);
        Trade trade = Trade.builder().id(id).price(price).quantity(quantity).position(position).build();
        return presentTrade.getStock().equals(name) && tradeRepository.updateTradeById(trade);
    }

    public boolean deleteTradeById(Integer id) {
        return tradeRepository.deleteTradeById(id);
    }

    public List<Trade> getTradesByEmail(String email) {
        return tradeRepository.getTradesByEmail(email);
    }
}
