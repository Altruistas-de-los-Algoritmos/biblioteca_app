package org.altruistas.backend_biblioteca.advisors;

import lombok.extern.log4j.Log4j2;
import org.altruistas.backend_biblioteca.exceptions.LibroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j2
@RestControllerAdvice
public class BibliotecaAdvisor {
    @ExceptionHandler(LibroNotFoundException.class)
    public ResponseEntity<Object> handleCustomersNotFoundException(
            LibroNotFoundException exception, WebRequest request) {
        log.warn(String.format("Handling libro not found exception for request %s [Input query params: %s]",
                Objects.nonNull(request) ? request.getDescription(true) : "",
                getQueryParamsMapString(Objects.nonNull(request) ? request.getParameterMap() : new HashMap<>())));
        return getNotFoundResponseEntity(exception.getMessage());
    }

    private String getQueryParamsMapString(Map<String, String[]> queryParamsMap) {
        return queryParamsMap.keySet().stream()
                .map(key -> key + "=" + Arrays.toString(queryParamsMap.get(key)))
                .collect(Collectors.joining(", ", "{", "}"));
    }

    private ResponseEntity<Object> getNotFoundResponseEntity(String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", HttpStatus.NOT_FOUND.toString());
        body.put("message", message);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
