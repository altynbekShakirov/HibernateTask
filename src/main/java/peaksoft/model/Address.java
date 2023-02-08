package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The golden boy
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "region_number")
    private  String regionName;
    private String street;
    @Column(name = "phone_number")
     private  int phoneNumber;
     @Column(name = "country_id")
     private Long countryId;
     @ManyToOne
     private Country country;
     @OneToOne
     private Programmer programmer;

}
