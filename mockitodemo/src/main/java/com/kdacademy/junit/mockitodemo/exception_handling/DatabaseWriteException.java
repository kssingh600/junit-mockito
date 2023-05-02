package com.kdacademy.junit.mockitodemo.exception_handling;

public class DatabaseWriteException extends RuntimeException{
    public DatabaseWriteException(String message){
        super(message) ;
    }
}
