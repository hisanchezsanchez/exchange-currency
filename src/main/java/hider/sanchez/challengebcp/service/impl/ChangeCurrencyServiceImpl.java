package hider.sanchez.challengebcp.service.impl;

import hider.sanchez.challengebcp.dto.RequestChange;
import hider.sanchez.challengebcp.dto.ResponseChange;
import hider.sanchez.challengebcp.entity.Change;
import hider.sanchez.challengebcp.entity.Currency;
import hider.sanchez.challengebcp.exception.NotFoundChange;
import hider.sanchez.challengebcp.exception.NotFoundCurrency;
import hider.sanchez.challengebcp.repository.ChangeRepository;
import hider.sanchez.challengebcp.repository.CurrencyRepository;
import hider.sanchez.challengebcp.service.ChangeCurrencyService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

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

    ResponseChange calculateChange(Change change, Currency origin, Currency target, Double amountToChange) {
        val changeType = change.getChangeType();
        val amountWithChange = changeType * amountToChange;
        val originName = origin.getName();
        val targetName = target.getName();
        return ResponseChange.of(amountToChange, amountWithChange, originName, targetName, changeType);
    }

    private Change getChangeActive(Currency origin, Currency target) throws NotFoundChange {
        return changeRepository.findOneByOrigenCurrencyIdAndDestinationCurrencyId(
                origin.getCurrencyId(),
                target.getCurrencyId()
        ).orElseThrow(() -> new NotFoundChange(origin.getCode(), target.getCode()));
    }

    private Currency getCurrency(String currencyCode) throws NotFoundCurrency {
        return currencyRepo.findOneByCode(currencyCode).orElseThrow(() -> new NotFoundCurrency(currencyCode));
    }
}
