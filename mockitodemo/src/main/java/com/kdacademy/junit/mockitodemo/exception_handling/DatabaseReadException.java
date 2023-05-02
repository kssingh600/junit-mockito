package com.kdacademy.junit.mockitodemo.exception_handling;

public class DatabaseReadException extends RuntimeException{

    public DatabaseReadException(String message){
        super(message) ;
    }
    
}
