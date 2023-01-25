package com.wuki.websites2watch.exception;

import com.wuki.websites2watch.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@ControllerAdvice
public class ApiExceptionHandler {

  Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

  @ExceptionHandler(value = Throwable.class)
  public ResponseEntity<ErrorResponse> handleErrors(HttpServletRequest request, Throwable exception) throws UnsupportedEncodingException {

    logger.error("ApiExceptionHandler.handleErrors", exception);

    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    int errorCode = status.value();
    String errorMessage = Optional.ofNullable(exception.getMessage())
      .orElse("An error occurred");
    String uriEncoded = URLDecoder.decode(request.getRequestURI(), StandardCharsets.UTF_8.toString());
    ErrorResponse errorInfo = new ErrorResponse(errorCode, errorMessage, uriEncoded);
    return new ResponseEntity<ErrorResponse>(errorInfo, status);
  }

  @ExceptionHandler(value = Website2watchException.class)
  public ResponseEntity<ErrorResponse> handleErrors(HttpServletRequest request, Website2watchException exception) throws UnsupportedEncodingException {

    logger.error("ApiExceptionHandler.handleErrors", exception);

    HttpStatus status = exception.getStatusCode();
    int errorCode = exception.getErrorCode();
    String errorMessage = exception.getMessage();
    String uriEncoded = URLDecoder.decode(request.getRequestURI(), StandardCharsets.UTF_8.toString());
    ErrorResponse errorInfo = new ErrorResponse(errorCode, errorMessage, uriEncoded);
    return new ResponseEntity<ErrorResponse>(errorInfo, status);
  }



  }


