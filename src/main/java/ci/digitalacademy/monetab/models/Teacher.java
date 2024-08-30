package ci.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
//@DiscriminatorValue(value = "teacher")
public class Teacher extends Person {


    @Column(name = "matiere", nullable = false)
    private String matiere;

    @Column(name = "vaccant", nullable = false)
    private Boolean vaccant;

    @Column(name = "genre", nullable = false)
    private String genre;

//    @OneToMany(mappedBy="teacher",fetch = FetchType.EAGER)
//    private Set<FicheNote> ficheNote;



}
