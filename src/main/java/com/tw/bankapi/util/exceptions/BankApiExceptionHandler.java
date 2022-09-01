package com.tw.bankapi.util.exceptions;

import com.tw.bankapi.util.ResponseInformation;
import com.tw.bankapi.util.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankApiExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(BankApiExceptionHandler.class);

    ResponseInformation responseInformation;
    public BankApiExceptionHandler(ResponseInformation responseInformation){
        this.responseInformation = responseInformation;
    }

    /**
     * This method is for handling our explicit exceptions (throw new PokemonCenterException)
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BankApiException.class)
    public ResponseEntity<Object> exception(BankApiException exception) {
        ResponseObject responseObject = null;
        if (null != exception.getResponseCode()) {
            String code = responseInformation.getResponseCode(exception.getResponseCode());
            String message = responseInformation.getResponseMessage(exception.getResponseCode());
            responseObject = new ResponseObject(HttpStatus.NOT_FOUND.value(), code, message, exception.getData());
        } else {
            responseObject = new ResponseObject(HttpStatus.NOT_FOUND.value(), exception.getCodeValue(), exception.getMessageValue(), exception.getData());
        }
        logger.info(String.format("PokemonCenterException : %s", exception.toString()));
        return new ResponseEntity<>(responseObject, HttpStatus.NOT_FOUND);
    }

    /**
     * This method handles uncontrolled exceptions
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exception(Exception exception) {
        logger.info(String.format("Exception : %s", exception.toString()));
        exception.printStackTrace();
        ResponseObject responseObject = new ResponseObject(HttpStatus.NOT_FOUND.value(), "ERROR", exception.toString(), null);
        return new ResponseEntity<>(responseObject, HttpStatus.NOT_FOUND);
    }

    /**
     * This method handles HttpMessageNotReadableException
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Object> exception(HttpMessageNotReadableException exception) {
        logger.info(String.format("Exception : %s", exception.toString()));
        exception.printStackTrace();
        ResponseObject responseObject = new ResponseObject(HttpStatus.NOT_FOUND.value(), "ERROR", "Error procesing data", null);
        return new ResponseEntity<>(responseObject, HttpStatus.NOT_FOUND);
    }
}
