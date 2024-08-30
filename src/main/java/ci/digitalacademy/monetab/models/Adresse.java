package ci.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Adresse")
@ToString
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Country", nullable = false)
    private String Country;


    @Column(name = "City", nullable = false)
    private String City;

    @Column(name = "Street", nullable = false )
    private String Street;

//    @OneToOne(mappedBy = "adresse")
//    private User user;
}
