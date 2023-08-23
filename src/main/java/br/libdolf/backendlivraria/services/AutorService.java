package br.libdolf.backendlivraria.services;

import br.libdolf.backendlivraria.DTOs.RequestAutorDTO;
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
        Autor autor = Autor.builder()
                .name(request.name())
                .gender(request.gender())
                .email(request.email())
                .country(request.country())
                .cpf(request.cpf())
                .birthDate(request.birthDate())
                .build();

        repository.save(autor);
    }

    public void update(Long id, RequestAutorDTO request) {
       Autor autor = repository.findById(id).orElseThrow();
       autor.setName(request.name());
       autor.setGender(request.gender());
       autor.setEmail(request.email());
       autor.setCountry(request.country());
       autor.setCpf(request.cpf());
       autor.setBirthDate(request.birthDate());

       repository.save(autor);
    }

    public List<Autor> getAutorsByObraTitle(String title) {
        return repository.findByObrasTitleContaining(title);
    }

    public List<Autor> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        Autor autor = repository.findById(id).orElseThrow();
        repository.delete(autor);
    }
}
