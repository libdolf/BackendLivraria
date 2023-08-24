package br.libdolf.backendlivraria.DTOs;

import br.libdolf.backendlivraria.entities.Autor.Gender;
import br.libdolf.backendlivraria.utils.Country;
import br.libdolf.backendlivraria.validations.CountryMatchesCPF;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@CountryMatchesCPF
@Data
public class RequestAutorDTO{
        @NotBlank(message = "O nome do autor não pode ser vazio ou nulo")
        private String name;
        private Gender gender;
        @Email
        private String email;
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
        private LocalDate birthDate;
        @NotNull(message = "O país não pode ser nulo")
        private Country country;
        private String cpf;
}
