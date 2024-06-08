package ir.najaftech.najafer.Exception;

import java.time.LocalDateTime;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
        ErrorDetails err = new ErrorDetails(ex.getMessage(), LocalDateTime.now(), req.getDescription(false));
        return new ResponseEntity<Object>(err, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidDetailsException.class)
    public final ResponseEntity<Object> handleInvalidDetailsException(Exception ex, WebRequest req) {
        ErrorDetails err = new ErrorDetails(ex.getMessage(), LocalDateTime.now(), req.getDescription(false));
        return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(PastReservationException.class)
    public final ResponseEntity<Object> handlePastReservationException(Exception ex, WebRequest req) {
        ErrorDetails err = new ErrorDetails(ex.getMessage(), LocalDateTime.now(), req.getDescription(false));
        return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public final ResponseEntity<Object> handleUserAlreadyExistsException(Exception ex, WebRequest req) {
        ErrorDetails err = new ErrorDetails(ex.getMessage(), LocalDateTime.now(), req.getDescription(false));
        return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
    }
}
