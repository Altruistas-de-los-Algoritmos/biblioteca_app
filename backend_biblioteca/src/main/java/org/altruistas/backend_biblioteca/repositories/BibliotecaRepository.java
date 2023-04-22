package org.altruistas.backend_biblioteca.repositories;

import org.altruistas.backend_biblioteca.entities.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends CrudRepository<Libro, String> {
}
