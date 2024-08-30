package ci.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "FicheNote")
public class FicheNote {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note", nullable = false)
    private String note;


    @Column(name = "annee", nullable = false)
    private String annee;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn
//    private Teacher teacher;

    @Override
    public String toString() {
        return "FicheNote{" +
                "id=" + id +
                ", annee='" + annee + '\'' +
                '}';
    }
}
