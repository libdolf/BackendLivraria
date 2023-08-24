package br.libdolf.backendlivraria.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate publicationDate;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate exposureDate;

    @ManyToMany
    @JoinTable(
            name = "obra_autor",
            joinColumns = @JoinColumn(name = "obra_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    @Column(nullable = false)
    private Set<Autor> autores = new HashSet<>();
}
