package br.libdolf.backendlivraria.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AutorController {
    private AutorService service;

    @PostMapping("/save")
    public ResponseEntity saveNewAutor(@RequestBody RequestAutorDTO request){
        service.save(request);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateAutor(@PathVariable Long id, RquestAutorDTO request){
        service.update(id, request);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/author/{obraname}")
    public ResponseEntity<List<Autor>> getByObraName(@PathVariable String obraname){
        return ResponseEntity.ok(service.getAutorByObraName(obraname));
    }
    @GetMapping(value = "/authors/all")
    public ResponseEntity<List<Autor>> listAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
