package org.altruistas.backend_biblioteca.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.altruistas.backend_biblioteca.models.GetLibroResponse;
import org.altruistas.backend_biblioteca.models.GetLibrosResponse;
import org.altruistas.backend_biblioteca.services.BibliotecaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/biblioteca-app/v1/")
public class BibliotecaController {
    private final BibliotecaService bibliotecaService;

    @GetMapping("libros")
    public ResponseEntity<GetLibrosResponse> getLibros() {
        log.info("GET /libros");
        return ResponseEntity.ok(bibliotecaService.getLibros());
    }

    @GetMapping("libros/{id}")
    public ResponseEntity<GetLibroResponse> getLibro(@PathVariable @NotNull String id) {
        log.info("GET /libros/{}", id);
        return ResponseEntity.ok(bibliotecaService.getLibro(id));
    }
}
