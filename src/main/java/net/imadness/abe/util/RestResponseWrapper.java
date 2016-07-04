package net.imadness.abe.util;

public class RestResponseWrapper<T> {
  
  private T data;
  private String errorMessage;

  public RestResponseWrapper(T data) {
    this.data = data;
  }
  
  public RestResponseWrapper(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  public RestResponseWrapper(T data, String errorMessage) {
    this.data = data;
    this.errorMessage = errorMessage;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
}
