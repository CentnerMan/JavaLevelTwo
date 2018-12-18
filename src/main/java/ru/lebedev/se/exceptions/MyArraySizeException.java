package ru.lebedev.se.exceptions;

import java.io.IOException;

public class MyArraySizeException extends IOException {
    public MyArraySizeException() {
    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
