package com.wuki.websites2watch.model;

public interface ISingleValue<T> {

  default T getVal() {
    return null;
  }

}
