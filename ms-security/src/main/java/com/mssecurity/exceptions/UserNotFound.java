package com.mssecurity.exceptions;

public class UserNotFound extends Exception {
    public UserNotFound(String mensaje) {
      super(mensaje);
    }
}