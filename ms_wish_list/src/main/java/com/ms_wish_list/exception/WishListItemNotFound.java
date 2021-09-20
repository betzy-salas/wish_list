package com.ms_wish_list.exception;

public class WishListItemNotFound extends Exception {
    public WishListItemNotFound(String mensaje) {
      super(mensaje);
    }
}