package ci.digitalacademy.monetab.services.dto;



import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class UserDTO {


    private Long id;


    private String pseudo;


    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
}
