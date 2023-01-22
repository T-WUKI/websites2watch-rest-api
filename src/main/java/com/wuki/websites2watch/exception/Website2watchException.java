package com.wuki.websites2watch.exception;

import org.springframework.http.HttpStatus;

public class Website2watchException extends  Exception {

  private final int errorCode;

  public HttpStatus getStatusCode() {
    switch (errorCode) {
      case 404: return HttpStatus.NOT_FOUND;
      default: return HttpStatus.INTERNAL_SERVER_ERROR;
    }
  }

  public int getErrorCode() {
    return errorCode;
  }

  public Website2watchException(String message, int errorCode) {
    super(message);
    this.errorCode = errorCode;
  }
}
