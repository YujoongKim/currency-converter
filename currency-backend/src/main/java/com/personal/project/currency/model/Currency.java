package com.personal.project.currency.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Currency {

    private String startingCurrency;
    private BigDecimal amount;
    private String endingCurrency;
    private BigDecimal exchangeRate;
    private LocalDateTime date;

    public Currency(String startingCurrency, BigDecimal amount, String endingCurrency, BigDecimal exchangeRate, LocalDateTime date) {
        this.startingCurrency = startingCurrency;
        this.amount = amount;
        this.endingCurrency = endingCurrency;
        this.exchangeRate = exchangeRate;
        this.date = date;
    }

    public Currency(){}

    public String getStartingCurrency() {
        return startingCurrency;
    }

    public void setStartingCurrency(String startingCurrency) {
        this.startingCurrency = startingCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getEndingCurrency() {
        return endingCurrency;
    }

    public void setEndingCurrency(String endingCurrency) {
        this.endingCurrency = endingCurrency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "startingCurrency=" + startingCurrency +
                ", amount=" + amount +
                ", endingCurrency=" + endingCurrency +
                ", exchangeRate=" + exchangeRate +
                ", date=" + date +
                '}';
    }
}
