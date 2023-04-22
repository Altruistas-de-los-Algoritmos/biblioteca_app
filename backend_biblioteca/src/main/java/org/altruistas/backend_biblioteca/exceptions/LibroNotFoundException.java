package org.altruistas.backend_biblioteca.exceptions;

public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(String message) {
        super(message);
    }
}
