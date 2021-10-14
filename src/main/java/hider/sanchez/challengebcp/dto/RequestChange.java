package hider.sanchez.challengebcp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class RequestChange {
    @Positive
    private Double amount;
    @NotBlank
    private String originCurrency;
    @NotBlank
    private String destinationCurrency;
}
