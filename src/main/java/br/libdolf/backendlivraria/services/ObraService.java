package br.libdolf.backendlivraria.services;

import br.libdolf.backendlivraria.DTOs.ResponseObraDTO;
import br.libdolf.backendlivraria.entities.Obra;
import br.libdolf.backendlivraria.repositories.ObraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ObraService {
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
}
