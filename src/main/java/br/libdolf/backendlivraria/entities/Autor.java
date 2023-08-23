package br.libdolf.backendlivraria.entities;

import br.libdolf.backendlivraria.utils.Country;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
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

    @Column(unique = true)
    private String email;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Country country;

    @Column(unique = true)
//    @CPF
    private String cpf;

    @ManyToMany(mappedBy = "autores")
    private Set<Obra> obras = new HashSet<>();

    public enum Gender{
        MALE, FEMALE, OTHER
    }

}
