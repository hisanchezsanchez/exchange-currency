package hider.sanchez.challengebcp.service.impl;

import hider.sanchez.challengebcp.dto.ResponseChange;
import hider.sanchez.challengebcp.entity.Change;
import hider.sanchez.challengebcp.entity.Currency;
import hider.sanchez.challengebcp.repository.ChangeRepository;
import hider.sanchez.challengebcp.repository.CurrencyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

class ChangeCurrencyServiceImplTest {
    public static final int CHANGE_PEN_ID = 222;
    public static final int CHANGE_USD_ID = 333;
    @MockBean
    private ChangeRepository changeRepository;
    @MockBean
    private CurrencyRepository currencyRepository;

    private ChangeCurrencyServiceImpl service;


    @BeforeEach
    void setUp() {
        service = new ChangeCurrencyServiceImpl(changeRepository, currencyRepository);
    }

    @Test
    void calculateChange() {
        Assertions.assertNotNull(service);
        Change change = getChange();

        Currency origin = getCurrencyUsd();
        Currency target = getCurrencyPen();
        Double amountToChange=1.0D;
        ResponseChange calculate = service.calculateChange(change, origin, target, amountToChange);
        Assertions.assertEquals(1.0, calculate.getAmount());
        Assertions.assertEquals(1.0*change.getChangeType(), calculate.getAmountWithChange());
        Assertions.assertEquals(origin.getName(), calculate.getOriginCurrency());
        Assertions.assertEquals(target.getName(), calculate.getDestinationCurrency());
        Assertions.assertEquals(change.getChangeType(), calculate.getChangeType());
    }

    private Change getChange() {
        Change change = new Change();
        change.setChangeId(111);
        change.setActive(true);
        change.setDate(new Date());
        change.setChangeType(4.004D);
        change.setDestinationCurrencyId(CHANGE_PEN_ID);
        change.setOrigenCurrencyId(CHANGE_USD_ID);
        return change;
    }

    private Currency getCurrencyUsd() {
        Currency currency = new Currency();
        currency.setCurrencyId(CHANGE_USD_ID);
        currency.setCode("USD");
        currency.setName("Dollar");
        currency.setSymbol("$");
        return currency;
    }

    private Currency getCurrencyPen() {
        Currency currency = new Currency();
        currency.setCurrencyId(CHANGE_PEN_ID);
        currency.setCode("PEN");
        currency.setName("Nuevo Sol");
        currency.setSymbol("S/");
        return currency;
    }

}