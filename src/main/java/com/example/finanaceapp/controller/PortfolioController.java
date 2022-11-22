package com.example.finanaceapp.controller;

import com.example.finanaceapp.model.Holding;
import com.example.finanaceapp.model.Trade;
import com.example.finanaceapp.services.TradeService;
import com.example.finanaceapp.utils.Constants;
import com.example.finanaceapp.utils.TradeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/portfolio")
public class PortfolioController {

    // TODO: Add User level auth for requests. eg- user should not be able to see other user's portfolio.

    public static final String PAGE_PORTFOLIO = "portfolio/portfolio";
    public static final String PAGE_PORTFOLIO_CREATE = "portfolio/create";
    public static final String PAGE_PORTFOLIO_READ = "portfolio/read";
    public static final String PAGE_PORTFOLIO_UPDATE = "portfolio/update";
    public static final String PAGE_PORTFOLIO_DELETE = "portfolio/delete";
    public static final String REDIRECT_TO_PORTFOLIO_PAGE = "redirect:/portfolio";

    // TODO: Remove this.
    public static final String DUMMY_EMAIL = "abc@gmail.com";

    @Autowired
    private TradeService tradeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String portfolioPage(ModelMap modelMap) {
        List<Trade> trades = tradeService.getTradesByEmail(DUMMY_EMAIL);
        modelMap.addAttribute("portfolio", trades);
        List<Holding> holdings = TradeUtils.getHoldingsFromTrades(trades);
        modelMap.addAttribute("holdings", holdings);
        return PAGE_PORTFOLIO;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createRecordInPortfolioPage() {
        return PAGE_PORTFOLIO_CREATE;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createRecordInPortfolio(@RequestParam(Constants.STOCK_NAME) String name,
                                          @RequestParam(Constants.STOCK_PRICE) Double price,
                                          @RequestParam(Constants.STOCK_QUANTITY) Double quantity,
                                          @RequestParam(Constants.STOCK_POSITION) String position) {
        boolean success = tradeService.createTrade(name, price, quantity, position, DUMMY_EMAIL);
        return success ? REDIRECT_TO_PORTFOLIO_PAGE : Constants.PAGE_ERROR;
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public String readRecordInPortfolioPage(@PathVariable("id") Integer id, ModelMap modelMap) {
        Trade trade = tradeService.getTradeById(id);
        modelMap.addAttribute(Constants.STOCK_NAME, trade.getStock());
        modelMap.addAttribute(Constants.STOCK_PRICE, trade.getPrice());
        modelMap.addAttribute(Constants.STOCK_QUANTITY, trade.getQuantity());
        modelMap.addAttribute(Constants.STOCK_POSITION, trade.getPosition());
        modelMap.addAttribute(Constants.STOCK_TIMESTAMP, trade.getTimestamp());
        return PAGE_PORTFOLIO_READ;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateRecordInPortfolioPage(@PathVariable("id") Integer id, ModelMap modelMap) {
        Trade trade = tradeService.getTradeById(id);
        if (Objects.isNull(trade)) {
            return Constants.PAGE_ERROR;
        }
        modelMap.addAttribute(Constants.TRADE_ID, trade.getId());
        modelMap.addAttribute(Constants.STOCK_NAME, trade.getStock());
        modelMap.addAttribute(Constants.STOCK_PRICE, trade.getPrice());
        modelMap.addAttribute(Constants.STOCK_QUANTITY, trade.getQuantity());
        modelMap.addAttribute(Constants.STOCK_POSITION, trade.getPosition());
        return PAGE_PORTFOLIO_UPDATE;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateRecordInPortfolio(@RequestParam(Constants.TRADE_ID) Integer id,
                                          @RequestParam(Constants.STOCK_NAME) String name,
                                          @RequestParam(Constants.STOCK_PRICE) Double price,
                                          @RequestParam(Constants.STOCK_QUANTITY) Double quantity,
                                          @RequestParam(Constants.STOCK_POSITION) String position) {
        boolean success = tradeService.updateTradeById(id, name, price, quantity, position);
        return success ? REDIRECT_TO_PORTFOLIO_PAGE : Constants.PAGE_ERROR;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRecordFromPortfolioPage(@PathVariable("id") Integer id, ModelMap modelMap) {
        modelMap.addAttribute(Constants.TRADE_ID, id);
        return PAGE_PORTFOLIO_DELETE;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteRecordFromPortfolio(@RequestParam(Constants.TRADE_ID) Integer id) {
        boolean success = tradeService.deleteTradeById(id);
        return success ? REDIRECT_TO_PORTFOLIO_PAGE : Constants.PAGE_ERROR;
    }

}
