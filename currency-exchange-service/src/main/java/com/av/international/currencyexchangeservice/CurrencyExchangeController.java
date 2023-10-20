package com.av.international.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class CurrencyExchangeController {

    private Logger logger= LoggerFactory.getLogger(CurrencyExchangeController.class);


    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeJPA service;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
//        CurrencyExchange currencyExchange = new CurrencyExchange(100L, from, to, BigDecimal.valueOf(50));

//        INFO [currency-exchange,e79c02b5a05a978b3ef580dc58ce38ba,2378d16e754b8bd4]
        logger.info("retrieveExchangeValue called with {} to {}",from,to);
        CurrencyExchange currencyExchange=service.findByFromAndTo(from, to);

        if(currencyExchange==null)
            throw new RuntimeException("Unable to find Currency Exchange");

        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
