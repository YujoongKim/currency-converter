package com.personal.project.currency.controller;

import com.personal.project.currency.dao.CurrencyDAO;
import com.personal.project.currency.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class AppController {
    @Autowired
    CurrencyDAO dao;

    @RequestMapping(path = "/allData", method = RequestMethod.GET )
    public List<Currency> getAllData(){

    return dao.getAllData();

    }

    @RequestMapping(path = "/newData", method = RequestMethod.POST)
    public void newData(@RequestBody Currency currency){
        currency.setDate(LocalDateTime.now());
    dao.createData(currency.getStartingCurrency(), currency.getAmount(), currency.getEndingCurrency(), currency.getExchangeRate(), currency.getDate());
        System.out.println(currency);
    }

}
