package com.mssecurity.exceptions;

public class ExpiredJwtException extends Exception {
    public ExpiredJwtException(String mensaje) {
      super(mensaje);
    }
}