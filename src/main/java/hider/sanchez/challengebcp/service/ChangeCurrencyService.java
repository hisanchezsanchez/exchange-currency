package hider.sanchez.challengebcp.service;

import hider.sanchez.challengebcp.dto.RequestChange;
import hider.sanchez.challengebcp.dto.RequestCurrencyMassive;
import hider.sanchez.challengebcp.dto.ResponseChange;
import hider.sanchez.challengebcp.exception.NotFoundChange;
import hider.sanchez.challengebcp.exception.NotFoundCurrency;

import java.util.List;

public interface ChangeCurrencyService {
    ResponseChange change(RequestChange request) throws NotFoundCurrency, NotFoundChange;

    String updateMassive(List<RequestCurrencyMassive> request);
}
