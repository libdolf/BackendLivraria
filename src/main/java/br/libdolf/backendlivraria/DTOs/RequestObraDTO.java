package br.libdolf.backendlivraria.DTOs;

import br.libdolf.backendlivraria.entities.Autor;
import br.libdolf.backendlivraria.entities.Obra;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class RequestObraDTO{
         private String title;
         private String description;
         private LocalDate publicationDate;
         private LocalDate exposureDate;
         private List<Long> idsAutor;

    public Obra toEntity(Set<Autor> autores) {
        return Obra.builder()
                .title(getTitle())
                .description(getDescription())
                .exposureDate(getExposureDate())
                .publicationDate(getPublicationDate())
                .autores(autores)
                .build();
    }
}
