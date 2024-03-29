package br.libdolf.backendlivraria.controllers;

import br.libdolf.backendlivraria.DTOs.RequestObraDTO;
import br.libdolf.backendlivraria.DTOs.ResponseObraDTO;
import br.libdolf.backendlivraria.entities.Obra;
import br.libdolf.backendlivraria.services.ObraService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/obra")
public class ObraController {
    private ObraService service;
    @GetMapping(value = "/{autorName}")
    public ResponseEntity<List<ResponseObraDTO>> listObrasByAutorName(@PathVariable String autorName){
        return ResponseEntity.ok(service.findObrasByAutorName(autorName));
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Obra>> findAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody @Valid RequestObraDTO request){
        service.save(request);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Long id,@Valid RequestObraDTO request) {
        service.update(id, request);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
