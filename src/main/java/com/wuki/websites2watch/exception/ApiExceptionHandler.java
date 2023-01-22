package com.wuki.websites2watch.exception;

import com.wuki.websites2watch.model.ErrorResponse;
import com.wuki.websites2watch.model.Response;
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
  public ResponseEntity<Response> handleErrors(HttpServletRequest request, Throwable exception) throws UnsupportedEncodingException {

    logger.error("ApiExceptionHandler.handleErrors", exception);

    //default
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    int errorCode = status.value();
    String errorMessage = Optional.ofNullable(exception.getMessage())
      .orElse("An error occurred");
    //expected
    if (exception instanceof Website2watchException) {
      status = ((Website2watchException) exception).getStatusCode();
      errorCode = ((Website2watchException) exception).getErrorCode();
    }
    String uriEncoded = URLDecoder.decode(request.getRequestURI(), StandardCharsets.UTF_8.toString());
    ErrorResponse errorInfo = new ErrorResponse(errorCode, errorMessage, uriEncoded);
    return ResponseEntity.status(status).body(errorInfo);
  }

}


