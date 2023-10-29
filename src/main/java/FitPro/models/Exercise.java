package FitPro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Exercise {
    @Id
    long id;

    String name;
    String type;
    String muscle;
    String equipment;
    String difficulty;
    String instructions;
}
