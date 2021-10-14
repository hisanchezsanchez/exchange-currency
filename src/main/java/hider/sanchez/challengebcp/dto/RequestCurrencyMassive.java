package hider.sanchez.challengebcp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class RequestCurrencyMassive {
    @NotBlank
    private String code;
    @Positive
    private Double amount;
}
