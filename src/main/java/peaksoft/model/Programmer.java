package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * The golden boy
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "programmers")
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "full_name")
     private String fullName;
     private  String email;
    @Column(name = "date_of_birth")


    private LocalDate dateOfBirth;
     private String status;
     private String location;
     @ManyToMany(cascade = {CascadeType.ALL},mappedBy = "programmers")
     private List<Project>projects;
     @OneToOne(mappedBy = "programmer",cascade = CascadeType.ALL)
     private Address address;
}
