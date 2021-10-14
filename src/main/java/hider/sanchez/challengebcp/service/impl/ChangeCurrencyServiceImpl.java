package hider.sanchez.challengebcp.service.impl;

import hider.sanchez.challengebcp.dto.RequestChange;
import hider.sanchez.challengebcp.dto.RequestCurrencyMassive;
import hider.sanchez.challengebcp.dto.ResponseChange;
import hider.sanchez.challengebcp.entity.Change;
import hider.sanchez.challengebcp.entity.Currency;
import hider.sanchez.challengebcp.exception.NotFoundChange;
import hider.sanchez.challengebcp.exception.NotFoundCurrency;
import hider.sanchez.challengebcp.repository.ChangeRepository;
import hider.sanchez.challengebcp.repository.CurrencyRepository;
import hider.sanchez.challengebcp.service.ChangeCurrencyService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ChangeCurrencyServiceImpl implements ChangeCurrencyService {
    private final ChangeRepository changeRepository;
    private final CurrencyRepository currencyRepo;

    @Autowired
    public ChangeCurrencyServiceImpl(ChangeRepository changeRepository, CurrencyRepository currencyRepo) {
        this.changeRepository = changeRepository;
        this.currencyRepo = currencyRepo;
    }

    @Override
    public ResponseChange change(RequestChange request) throws NotFoundCurrency, NotFoundChange {
        val originCurrencyCode = request.getOriginCurrency();
        val targetCurrencyCode = request.getDestinationCurrency();
        val originCurrency = getCurrency(originCurrencyCode);
        val targetCurrency = getCurrency(targetCurrencyCode);
        val change = getChangeActive(originCurrency, targetCurrency);
        return calculateChange(change, originCurrency, targetCurrency, request.getAmount());
    }

    @Override
    @Transactional
    public String updateMassive(List<RequestCurrencyMassive> request) {
        request.forEach(it -> {
            Currency newCurrency = new Currency();
            newCurrency.setCode(it.getCode());
            val currency = currencyRepo.findOneByCode(it.getCode()).orElse(newCurrency);

            Change newChange = new Change();
            newChange.setDate(new Date());
            newChange.setCurrencyCode(it.getCode());
            newChange.setChangeType(it.getAmount());
            val change = changeRepository.findOneByCurrencyCode(it.getCode()).orElse(newChange);
            changeRepository.save(change);
            currencyRepo.save(currency);
        });
        return "Update Data Ok";
    }

    ResponseChange calculateChange(Change change, Currency origin, Currency target, Double amountToChange) {
        val changeType = change.getChangeType();
        val amountWithChange = changeType * amountToChange;
        val originCode = origin.getCode();
        val targetCode = target.getCode();
        return ResponseChange.of(amountToChange, amountWithChange, originCode, targetCode, changeType);
    }

    private Change getChangeActive(Currency origin, Currency target) throws NotFoundChange {
        return changeRepository.findOneByCurrencyCode(target.getCode()).orElseThrow(() -> new NotFoundChange(origin.getCode(), target.getCode()));
    }

    private Currency getCurrency(String currencyCode) throws NotFoundCurrency {
        return currencyRepo.findOneByCode(currencyCode).orElseThrow(() -> new NotFoundCurrency(currencyCode));
    }
}
