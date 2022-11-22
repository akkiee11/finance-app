package com.example.finanaceapp.controller;

import com.example.finanaceapp.model.IdealPortfolio;
import com.example.finanaceapp.model.InvestorMode;
import com.example.finanaceapp.services.IdealPortfolioService;
import com.example.finanaceapp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ideal-portfolio")
public class IdealPortfolioController {

    @Autowired
    private IdealPortfolioService idealPortfolioService;

    // TODO: Remove this.Constants
    //TradeUtils
    public static final String DUMMY_EMAIL = "abc@gmail.com";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String idealPortfolioPage(ModelMap modelMap) {
        modelMap.addAttribute("ideal_portfolio_list", idealPortfolioService.getIdealPortfoliosByEmail(DUMMY_EMAIL));
        return "ideal_portfolio/idealportfolio";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createIdealPortfolioPage() {
        return "ideal_portfolio/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createIdealPortfolioPageSubmit(@RequestParam(Constants.IP_CAPITAL) Double capital,
                                                 @RequestParam(Constants.IP_MODE) InvestorMode mode,
                                                 @RequestParam(Constants.IP_NAME) String name) {
        boolean success = idealPortfolioService.createAndStoreIdealPortfolio(DUMMY_EMAIL, capital, mode, name);
        return success ? "redirect:/ideal-portfolio" : Constants.PAGE_ERROR;
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public String idealPortfolioPage(ModelMap modelMap, @PathVariable("id") Integer id) {
        IdealPortfolio idealPortfolio = idealPortfolioService.getIdealPortfolioById(id);
        modelMap.addAttribute("ideal_portfolio", idealPortfolio);
        return "ideal_portfolio/read";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteIdealPortfolioPage(ModelMap modelMap, @PathVariable("id") Integer id) {
        modelMap.addAttribute("id", id);
        return "ideal_portfolio/delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteIdealPortfolio(@RequestParam("ip_id") Integer id) {
        boolean success = idealPortfolioService.deleteIdealPortfolioById(id);
        return success ? "redirect:/ideal-portfolio" : Constants.PAGE_ERROR;
    }

}
