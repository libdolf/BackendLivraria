package br.libdolf.backendlivraria.repositories;

import br.libdolf.backendlivraria.entities.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObraRepository extends JpaRepository<Obra, Long> {
    List<Obra> findByAutoresNameContaining(String name);
}
