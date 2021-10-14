package hider.sanchez.challengebcp.rest.advisor;

import hider.sanchez.challengebcp.exception.NotFoundChange;
import hider.sanchez.challengebcp.exception.NotFoundCurrency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NotFoundCurrency.class, NotFoundChange.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex) {
        log.error("Error sobre db {}", ex.getMessage());
        return ResponseEntity.notFound().build();
    }
}