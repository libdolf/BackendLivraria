package br.libdolf.backendlivraria.DTOs;

import br.libdolf.backendlivraria.entities.Autor;
import br.libdolf.backendlivraria.utils.Country;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ResponseAutorDTO{
        private Long id;
        private String name;
        private Autor.Gender gender;
        private String email;
        private LocalDate birthDate;
        private Country country;
        private String cpf;

    public ResponseAutorDTO(Autor autor) {
        this.id = autor.getId();
        this.name = autor.getName();
        this.gender = autor.getGender();
        this.email = autor.getEmail();
        this.birthDate = autor.getBirthDate();
        this.country = autor.getCountry();
        this.cpf = autor.getCpf();
    }
}
