package com.example.finanaceapp.services;

import com.example.finanaceapp.dao.IdealPortfolioRepository;
import com.example.finanaceapp.model.IdealPortfolio;
import com.example.finanaceapp.model.IdealPortfolioRecommendation;
import com.example.finanaceapp.model.InvestorMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class IdealPortfolioService {


    @Autowired
    private IdealPortfolioRepository idealPortfolioRepository;

    public List<IdealPortfolio> getIdealPortfoliosByEmail(String email) {
        return idealPortfolioRepository.getIdealPortfoliosByEmail(email);
    }

    public boolean createAndStoreIdealPortfolio(String email, Double capital, InvestorMode mode, String name) {
        IdealPortfolio idealPortfolio = buildIdealPortfolio(email, capital, mode, name);
        return idealPortfolioRepository.createIdealPortfolio(idealPortfolio);
    }


    public IdealPortfolio getIdealPortfolioById(Integer id) {
        return idealPortfolioRepository.getIdealPortfolioById(id);
    }

    public boolean deleteIdealPortfolioById(Integer id) {
        return idealPortfolioRepository.deleteIdealPortfolioById(id);
    }
    public IdealPortfolio buildIdealPortfolio(String email, Double capital, InvestorMode mode, String name) {
        List<IdealPortfolioRecommendation> recommendations = null;
        switch (mode) {
            case PASSIVE:
                recommendations = Arrays.asList(
                        IdealPortfolioRecommendation.builder().stock("XYZ").percentage(25D).stockType("MC").build(),
                        IdealPortfolioRecommendation.builder().stock("ABC").percentage(25D).stockType("SC").build(),
                        IdealPortfolioRecommendation.builder().stock("DEF").percentage(50D).stockType("LC").build());
                break;
            case MODERATE:
                recommendations = Arrays.asList(
                        IdealPortfolioRecommendation.builder().stock("XYZ").percentage(25D).stockType("MC").build(),
                        IdealPortfolioRecommendation.builder().stock("ABC").percentage(25D).stockType("SC").build(),
                        IdealPortfolioRecommendation.builder().stock("DEF").percentage(50D).stockType("LC").build());
                break;
            case AGGRESSIVE:
                recommendations = Arrays.asList(
                        IdealPortfolioRecommendation.builder().stock("XYZ").percentage(25D).stockType("MC").build(),
                        IdealPortfolioRecommendation.builder().stock("ABC").percentage(25D).stockType("SC").build(),
                        IdealPortfolioRecommendation.builder().stock("DEF").percentage(50D).stockType("LC").build());
                break;
        }
        return IdealPortfolio.builder().email(email).amount(capital).mode(mode).name(name).recommendations(recommendations).build();
    }
}
