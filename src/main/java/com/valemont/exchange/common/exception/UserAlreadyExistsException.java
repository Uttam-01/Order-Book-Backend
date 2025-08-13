package com.valemont.exchange.common.exception;

public class UserAlreadyExistsException extends RuntimeException{

     public UserAlreadyExistsException(String message){
         super(message);
     }
}
