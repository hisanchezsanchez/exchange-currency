package hider.sanchez.challengebcp.rest.v1;

import hider.sanchez.challengebcp.dto.RequestChange;
import hider.sanchez.challengebcp.dto.ResponseChange;
import hider.sanchez.challengebcp.exception.NotFoundChange;
import hider.sanchez.challengebcp.exception.NotFoundCurrency;
import hider.sanchez.challengebcp.service.ChangeCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("exchange/v1/")
@RequiredArgsConstructor
public class ExchangeCurrencyController {
    private final ChangeCurrencyService service;

    @PostMapping("calculate")
    public ResponseEntity<ResponseChange> calculateChangeCurrency(@Validated @RequestBody RequestChange request) throws NotFoundCurrency, NotFoundChange {
        return ResponseEntity.ok(service.change(request));
    }

}
