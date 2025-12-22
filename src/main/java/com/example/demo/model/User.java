import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data        // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder     // allows User.builder().name(...).build()
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    @Column(nullable = false)
    private String role = "RESIDENT";

    @OneToOne(mappedBy = "owner")
    private ApartmentUnit apartmentUnit;
}
