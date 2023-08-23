package br.libdolf.backendlivraria.repositories;

import br.libdolf.backendlivraria.entities.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Long> {
}
