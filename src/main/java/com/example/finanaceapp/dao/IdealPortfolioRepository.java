package com.example.finanaceapp.dao;

import com.example.finanaceapp.model.IdealPortfolio;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class IdealPortfolioRepository {
    List<IdealPortfolio> idealPortfolioList = new ArrayList<>();

    public IdealPortfolio getIdealPortfolioById(Integer id) {
        for (IdealPortfolio idealPortfolio : idealPortfolioList) {
            if (idealPortfolio.getId() == id) {
                return idealPortfolio;
            }
        }
        return null;
    }

    public boolean deleteIdealPortfolioById(Integer id) {
        for (IdealPortfolio idealPortfolio : idealPortfolioList) {
            if (idealPortfolio.getId() == id) {
                idealPortfolioList.remove(idealPortfolio);
                break;
            }
        }
        return true;
    }

    public List<IdealPortfolio> getIdealPortfoliosByEmail(String email) {
        List<IdealPortfolio> idealPortfolios = new ArrayList<>();
        for (IdealPortfolio idealPortfolio : idealPortfolioList) {
            if (Objects.equals(idealPortfolio.getEmail(), email)) {
                idealPortfolios.add(idealPortfolio);
            }
        }
        return idealPortfolios;
    }

    public boolean createIdealPortfolio(IdealPortfolio idealPortfolio) {
        idealPortfolioList.add(idealPortfolio);
        return true;
    }
}
