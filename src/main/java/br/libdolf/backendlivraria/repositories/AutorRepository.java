package br.libdolf.backendlivraria.repositories;

import br.libdolf.backendlivraria.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
