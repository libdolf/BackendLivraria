package br.libdolf.backendlivraria.services;

import br.libdolf.backendlivraria.entities.Autor;
import br.libdolf.backendlivraria.repositories.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutorService {
    
    private AutorRepository repository;

    public void save(RequestAutorDTO request) {
    }

    public void update(Long id, RquestAutorDTO request) {
    }

    public List<Autor> getAutorByObraName(String obraname) {
    }

    public List<Autor> getAll() {
    }

    public void delete(Long id) {
    }
}
