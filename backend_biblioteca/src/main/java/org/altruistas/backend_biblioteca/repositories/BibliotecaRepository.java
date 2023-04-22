package org.altruistas.backend_biblioteca.repositories;

import org.altruistas.backend_biblioteca.entities.Libro;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface BibliotecaRepository extends CrudRepository<Libro, String> {
    List<Libro> findAll();
}
