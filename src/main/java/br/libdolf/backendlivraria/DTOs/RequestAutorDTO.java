package br.libdolf.backendlivraria.DTOs;

import br.libdolf.backendlivraria.entities.Autor.Gender;
import br.libdolf.backendlivraria.utils.Country;

import java.time.LocalDate;

public record RequestAutorDTO(
        String name,
        Gender gender,
        String email,
        LocalDate birthDate,
        Country country,
        String cpf
        ) {
}
