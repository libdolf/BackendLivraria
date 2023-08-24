package br.libdolf.backendlivraria.services;

import br.libdolf.backendlivraria.DTOs.RequestObraDTO;
import br.libdolf.backendlivraria.DTOs.ResponseObraDTO;
import br.libdolf.backendlivraria.entities.Autor;
import br.libdolf.backendlivraria.entities.Obra;
import br.libdolf.backendlivraria.exceptions.NotFoundException;
import br.libdolf.backendlivraria.repositories.ObraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ObraService {
    private AutorService service;
    private ObraRepository repository;
    public List<ResponseObraDTO> findObrasByAutorName(String name) {
        List<Obra> obrasEntity =  repository.findByAutoresNameContaining(name);
        List<ResponseObraDTO> obrasDto = new ArrayList<>();
        for(Obra o : obrasEntity){
            ResponseObraDTO responseObraDTO = new ResponseObraDTO(o);
            obrasDto.add(responseObraDTO);
        }
        return obrasDto;
    }

    public List<Obra> getAll(){
        return repository.findAll();
    }

    public void save(RequestObraDTO request) {
        Set<Autor> autorSet = new HashSet<>();
        for (Long i: request.getIdsAutor()){
            Autor autor = service.getById(i);
            autorSet.add(autor);
        }
        Obra obra = request.toEntity(autorSet);
    }

    public void update(Long id, RequestObraDTO request) {
        Set<Autor> autorSet = new HashSet<>();
        for (Long i: request.getIdsAutor()){
            Autor autor = service.getById(i);
            autorSet.add(autor);
        }

        Obra obra = repository.findById(id).orElseThrow(()-> new NotFoundException("Obra não encontrada"));
        obra.setTitle(request.getTitle());
        obra.setDescription(request.getDescription());
        obra.setExposureDate(request.getExposureDate());
        obra.setPublicationDate(request.getPublicationDate());
        obra.setAutores(autorSet);

        repository.save(obra);
    }

    public void delete(Long id) {
        Obra obra = repository.findById(id).orElseThrow(()-> new NotFoundException("Obra não encontrada"));
        repository.delete(obra);
    }
}
