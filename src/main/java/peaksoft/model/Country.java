package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The golden boy
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String country;

    private String description;
    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    private List<Address>addresses;
}
