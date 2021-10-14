package hider.sanchez.challengebcp.rest.v1;

import hider.sanchez.challengebcp.dto.RequestCurrencyMassive;
import hider.sanchez.challengebcp.service.ChangeCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("currency/v1/")
@RequiredArgsConstructor
public class UpdateCurrencyController {
    private final ChangeCurrencyService service;

    @PostMapping("update")
    public ResponseEntity<String> updateCurrencyMassive(@Validated @RequestBody List<RequestCurrencyMassive> currencies) {
        return ResponseEntity.ok(service.updateMassive(currencies));
    }

}
