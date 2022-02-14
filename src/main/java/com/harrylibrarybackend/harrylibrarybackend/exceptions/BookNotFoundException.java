package com.harrylibrarybackend.harrylibrarybackend.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }
}
