package br.libdolf.backendlivraria.services;

import br.libdolf.backendlivraria.DTOs.RequestAutorDTO;
import br.libdolf.backendlivraria.DTOs.ResponseAutorDTO;
import br.libdolf.backendlivraria.entities.Autor;
import br.libdolf.backendlivraria.repositories.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AutorService {
    
    private AutorRepository repository;

    public void save(RequestAutorDTO request) {
        Autor autor = Autor.builder()
                .name(request.getName())
                .gender(request.getGender())
                .email(request.getEmail())
                .country(request.getCountry())
                .cpf(request.getCpf())
                .birthDate(request.getBirthDate())
                .build();

        repository.save(autor);
    }

    public void update(Long id, RequestAutorDTO request) {
       Autor autor = repository.findById(id).orElseThrow();
       autor.setName(request.getName());
       autor.setGender(request.getGender());
       autor.setEmail(request.getEmail());
       autor.setCountry(request.getCountry());
       autor.setCpf(request.getCpf());
       autor.setBirthDate(request.getBirthDate());

       repository.save(autor);
    }

    public List<ResponseAutorDTO> getAutorsByObraTitle(String title) {
        List<Autor> autores = repository.findByObrasTitleContaining(title);
        List<ResponseAutorDTO> response = new ArrayList<>();
        for (Autor autor: autores){
            ResponseAutorDTO autorDTO = new ResponseAutorDTO(autor);
            response.add(autorDTO);
        }
        return response;
    }

    public List<Autor> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        Autor autor = repository.findById(id).orElseThrow();
        repository.delete(autor);
    }

    public Autor getById(Long id){
        return repository.findById(id).orElseThrow();
    }
}
