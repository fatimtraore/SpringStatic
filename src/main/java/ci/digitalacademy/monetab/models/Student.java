package ci.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Student extends Person{


    @Column(name = "matricule", nullable = false)
    private String matricule;

    @Column(name = "classe", nullable = false)
    private String classe;

    @Column(name = "genre", nullable = false)
    private String genre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_Naissance", nullable = false)
    private Date dateNaissance;



}
