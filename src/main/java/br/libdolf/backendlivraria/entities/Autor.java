package br.libdolf.backendlivraria.entities;

import br.libdolf.backendlivraria.utils.Country;

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
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    @DateTimeFormat(pattern = "dd-mm-yyy")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String cpf;

    @ManyToMany(mappedBy = "autor")
    private Set<Obra> obras = new HashSet<>();

    public enum Gender{
        MALE, FEMALE, OTHER
    }

}
