package hider.sanchez.challengebcp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotNull;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundCurrency extends RuntimeException {
    private final String error;

    public NotFoundCurrency(@NotNull String currencyCode) {
        super(getMessage(currencyCode), null, true, false);
        this.error = getMessage(currencyCode);
    }

    private static String getMessage(@NotNull String currencyCode) {
        final String MESSAGE_ERROR = "Not found Currency %s";
        return String.format(MESSAGE_ERROR, currencyCode);
    }
}
