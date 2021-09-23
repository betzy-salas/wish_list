package com.api.google.books.exception;

public class InvalidCredentials extends Exception {
    public InvalidCredentials(String mensaje) {
      super(mensaje);
    }
}