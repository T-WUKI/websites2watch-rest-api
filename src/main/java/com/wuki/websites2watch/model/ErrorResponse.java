package com.wuki.websites2watch.model;

public class ErrorResponse implements Response {

  public ErrorResponse(int errorCode, String errorMessage, String path) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.path = path;
  }

  private int errorCode;
  private String errorMessage;
  private String path;

  public int getErrorCode() {
    return errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public String getPath() {
    return path;
  }
}

