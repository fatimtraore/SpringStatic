package ci.digitalacademy.monetab.services.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class StudentDTO extends PersonDTO{


    private String matricule;


    private String classe;


    private String genre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
}
