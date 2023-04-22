package org.altruistas.backend_biblioteca.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.altruistas.backend_biblioteca.entities.Libro;
import org.altruistas.backend_biblioteca.exceptions.LibroNotFoundException;
import org.altruistas.backend_biblioteca.mappers.LibrosMapper;
import org.altruistas.backend_biblioteca.models.GetLibroResponse;
import org.altruistas.backend_biblioteca.models.GetLibrosResponse;
import org.altruistas.backend_biblioteca.repositories.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class BibliotecaService {
    private final BibliotecaRepository bibliotecaRepository;
    private final LibrosMapper librosMapper;

    public GetLibrosResponse getLibros() {
        List<Libro> libros = bibliotecaRepository.findAll();
        return GetLibrosResponse.builder()
                .libroDTOList(librosMapper.librosListToLibrosDTOList(libros))
                .build();
    }

    public GetLibroResponse getLibro(final String id) {
        Libro libro = bibliotecaRepository.findById(id).orElseThrow(() ->
                new LibroNotFoundException(String.format("El libro con id %s no existe", id)));
        return GetLibroResponse.builder()
                .libroDTO(librosMapper.libroToLibroDTO(libro))
                .build();
    }
}
