package hider.sanchez.challengebcp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundChange extends RuntimeException {
    private final String error;

    public NotFoundChange(String originCurrencyCode, String targetCurrencyCode) {
        super(getMessage(originCurrencyCode, targetCurrencyCode), null, true, false);
        this.error = getMessage(originCurrencyCode, targetCurrencyCode);
    }

    private static String getMessage(String originCurrencyCode, String targetCurrencyCode) {
        final String MESSAGE_ERROR = "Not found Change with originCurrency: %s  and destinationCurrency:%s";
        return String.format(MESSAGE_ERROR, originCurrencyCode, targetCurrencyCode);
    }
}
