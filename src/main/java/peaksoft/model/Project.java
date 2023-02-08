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
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;
    @Column(name = "project_name")
    private  String projectName;
     private String description;
    @Column(name = "date_of_stars")

    private LocalDate dateOfStart;
    @Column(name = "date_of_finish")

    private LocalDate dateOfFinish;
      private  int price;
      @ManyToMany(cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
      private List<Programmer>programmers;

}
