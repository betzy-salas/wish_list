package com.msuser.exceptions;

public class UserNotFound extends Exception {
    public UserNotFound(String mensaje) {
      super(mensaje);
    }
}