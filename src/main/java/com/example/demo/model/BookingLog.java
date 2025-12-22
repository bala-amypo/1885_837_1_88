import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Booking booking;

    @Column(nullable = false)
    private String logMessage;

    private LocalDateTime loggedAt;
}
