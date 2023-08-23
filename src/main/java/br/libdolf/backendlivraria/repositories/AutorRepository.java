package br.libdolf.backendlivraria.repositories;

import br.libdolf.backendlivraria.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByObrasTitleContaining(String title);
}
