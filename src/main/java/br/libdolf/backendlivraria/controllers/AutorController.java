package br.libdolf.backendlivraria.controllers;

import br.libdolf.backendlivraria.DTOs.RequestAutorDTO;
import br.libdolf.backendlivraria.DTOs.ResponseAutorDTO;
import br.libdolf.backendlivraria.entities.Autor;
import br.libdolf.backendlivraria.services.AutorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/autor")
public class AutorController {
    private AutorService service;

    @PostMapping("/save")
    public ResponseEntity saveNewAutor(@RequestBody @Valid RequestAutorDTO request){
        service.save(request);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateAutor(@PathVariable Long id, @Valid RequestAutorDTO request){
        service.update(id, request);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/{obraname}")
    public ResponseEntity<List<ResponseAutorDTO>> getByObraName(@PathVariable String obraname){
        return ResponseEntity.ok(service.getAutorsByObraTitle(obraname));
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Autor>> listAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
