package org.altruistas.backend_biblioteca.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.altruistas.backend_biblioteca.entities.Libro;
import org.altruistas.backend_biblioteca.mappers.LibrosMapper;
import org.altruistas.backend_biblioteca.models.GetLibroResponse;
import org.altruistas.backend_biblioteca.models.GetLibrosResponse;
import org.altruistas.backend_biblioteca.models.LibroDTO;
import org.altruistas.backend_biblioteca.repositories.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Log4j2
@RequiredArgsConstructor
@Service
public class BibliotecaService {
    private final BibliotecaRepository bibliotecaRepository;
    private final LibrosMapper librosMapper;

    public GetLibrosResponse getLibros() {
        return GetLibrosResponse.builder()
                .libroDTOList(Collections.singletonList(LibroDTO.builder()
                        .isbn13("01234567890")
                        .isbn10("01234")
                        .title("Title")
                        .subtitle("Subtitle")
                        .authors("An Author")
                        .categories("Sci-Fi")
                        .thumbnail("https://thumbnail.com")
                        .description("An empty description")
                        .publishedYear(2023)
                        .averageRating(3.5)
                        .build()))
                .build();
    }

    public GetLibroResponse getLibro(final String id) {
        Libro libro = Libro.builder()
                .id(id)
                .isbn13("01234567890")
                .isbn10("01234")
                .title("Title")
                .subtitle("Subtitle")
                .authors("An Author")
                .categories("Sci-Fi")
                .thumbnail("https://thumbnail.com")
                .description("An empty description")
                .publishedYear(2023)
                .averageRating(3.5)
                .build();
        return GetLibroResponse.builder()
                .libroDTO(librosMapper.libroToLibroDTO(libro))
                .build();
    }
}
