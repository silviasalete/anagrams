package org.example.exceptions;

public class InvalidCharacterException extends RuntimeException{

    public InvalidCharacterException(String message) {
        super(message);
    }
}
