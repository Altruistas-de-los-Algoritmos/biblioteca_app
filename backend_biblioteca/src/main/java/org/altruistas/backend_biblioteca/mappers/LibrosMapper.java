package org.altruistas.backend_biblioteca.mappers;

import org.altruistas.backend_biblioteca.entities.Libro;
import org.altruistas.backend_biblioteca.models.LibroDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibrosMapper {
    LibroDTO libroToLibroDTO(Libro libro);
}
