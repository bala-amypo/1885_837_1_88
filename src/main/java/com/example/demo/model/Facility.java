import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "facilities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @Column(nullable = false)
    private String openTime;   // format HH:mm

    @Column(nullable = false)
    private String closeTime;  // format HH:mm
}
