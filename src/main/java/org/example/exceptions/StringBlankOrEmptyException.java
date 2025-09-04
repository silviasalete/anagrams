package org.example.exceptions;

public class StringBlankOrEmptyException extends RuntimeException{

    public StringBlankOrEmptyException(String message) {
        super(message);
    }
}
