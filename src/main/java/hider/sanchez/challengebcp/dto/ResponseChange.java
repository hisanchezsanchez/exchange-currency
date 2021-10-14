package hider.sanchez.challengebcp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class ResponseChange {
    private Double amount;
    private Double amountWithChange;
    private String originCurrency;
    private String destinationCurrency;
    private Double changeType;
}
