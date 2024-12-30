package com.app.ecommerce.core.config;

import com.app.ecommerce.core.result.ResultData;
import com.app.ecommerce.core.utilies.Msg;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> validationErrorList = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).toList();

        ResultData<List<String>> resultData = new ResultData<>(false, Msg.VALIDATE_ERROR, "400", validationErrorList);
        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ResultData<String>> handleNotFoundException(ChangeSetPersister.NotFoundException ex) {
        ResultData<String> resultData = new ResultData<>(false, Msg.NOT_FOUND_ERROR, "404", ex.getMessage());
        return new ResponseEntity<>(resultData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ResultData<String>> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
        ResultData<String> resultData = new ResultData<>(false, Msg.UNSUPPORTED_MEDIA_TYPE, "415", ex.getMessage());
        return new ResponseEntity<>(resultData, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultData<String>> handleGeneralException(Exception ex) {
        String errorMessage = "An unexpected error occurred: " + ex.getMessage();
        ResultData<String> resultData = new ResultData<>(false, Msg.GENERAL_ERROR, "500", errorMessage);
        return new ResponseEntity<>(resultData, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
