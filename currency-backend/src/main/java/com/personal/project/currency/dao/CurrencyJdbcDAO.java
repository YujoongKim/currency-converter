package com.personal.project.currency.dao;

import com.personal.project.currency.model.Currency;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyJdbcDAO implements CurrencyDAO {
    private JdbcTemplate jdbcTemplate;

    public CurrencyJdbcDAO (DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Currency> getAllData() {
        String sql = "SELECT * FROM currency";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Currency> currencyList = new ArrayList<>();

        while (results.next()) {
            currencyList.add(rowToCurrecncy(results));
        }
        return currencyList;
    }

    @Override
    public void createData(String startingCurrency, BigDecimal amount, String endingCurrency, BigDecimal exchangeRate, LocalDateTime date) {
        String sql = "INSERT INTO currency (starting_currency, amount, ending_currency, exchange_rate, date) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, startingCurrency, amount, endingCurrency, exchangeRate, date);
    }


    private Currency rowToCurrecncy(SqlRowSet sqlRowSet){
        Currency currency = new Currency();
        currency.setStartingCurrency(sqlRowSet.getString("starting_currency"));
        currency.setAmount(sqlRowSet.getBigDecimal("amount"));
        currency.setEndingCurrency(sqlRowSet.getString("ending_currency"));
        currency.setExchangeRate(sqlRowSet.getBigDecimal("exchange_rate"));
        currency.setDate(sqlRowSet.getTimestamp("date").toLocalDateTime());
        return currency;
    }

}
