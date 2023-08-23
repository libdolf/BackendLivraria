package br.libdolf.backendlivraria.DTOs;

import br.libdolf.backendlivraria.entities.Obra;

import java.time.LocalDate;


public class ResponseObraDTO{
        private String title;
        private String description;
        private LocalDate publicationDate;
        private LocalDate exposureDate;

    public ResponseObraDTO(Obra obra) {
        this.title = obra.getTitle();
        this.description = obra.getDescription();
        this.publicationDate = obra.getPublicationDate();
        this.exposureDate = obra.getExposureDate();
    }
}
