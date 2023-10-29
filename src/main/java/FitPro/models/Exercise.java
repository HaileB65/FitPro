package FitPro.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Exercise {
    String name;
    String type;
    String muscle;
    String equipment;
    String difficulty;
    String instructions;
}
