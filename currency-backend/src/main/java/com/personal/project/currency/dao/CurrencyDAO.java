package com.personal.project.currency.dao;

import com.personal.project.currency.model.Currency;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface CurrencyDAO {
    List<Currency> getAllData();
    void createData (String startingCurrency, BigDecimal amount, String endingCurrency, BigDecimal exchangeRate, LocalDateTime date);

}
