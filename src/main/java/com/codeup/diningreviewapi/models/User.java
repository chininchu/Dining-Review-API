import com.codeup.diningreviewapi.models.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)

    private String displayName;


    private String city;
    private String state;
    private String zipcode;

    private boolean interestedInPeanutAllergies;
    private boolean interestedInEggAllergies;
    private boolean interestedInDairyAllergies;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;


}
