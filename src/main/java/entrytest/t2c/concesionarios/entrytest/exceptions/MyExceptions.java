package entrytest.t2c.concesionarios.entrytest.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MyExceptions extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public MyExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
