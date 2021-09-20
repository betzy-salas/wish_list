package com.ms_wish_list.exception;

public class UserNotFound extends Exception {
    public UserNotFound(String mensaje) {
      super(mensaje);
    }
}