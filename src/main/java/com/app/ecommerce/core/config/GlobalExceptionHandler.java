package com.app.ecommerce.core.config;

import com.app.ecommerce.core.result.ResultData;
import com.app.ecommerce.core.utilies.ResultHelper;
import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> validationErrorList = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();

        return new ResponseEntity<>(ResultHelper.validateError(validationErrorList), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ResultData<String>> handleNotFoundException(ChangeSetPersister.NotFoundException ex) {
        return new ResponseEntity<>(ResultHelper.notFound(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ResultData<String>> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
        return new ResponseEntity<>(ResultHelper.unsupportedMediaType(ex.getMessage()), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ResultData<String>> handleAccessDeniedException(AccessDeniedException ex) {
        return new ResponseEntity<>(ResultHelper.accessDenied(ex.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResultData<String>> handleBadRequestException(BadRequestException ex) {
        return new ResponseEntity<>(ResultHelper.badRequest(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultData<String>> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(ResultHelper.generalError("An unexpected error occurred: " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

