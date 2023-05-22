package ee.valiit.events.domain.spot;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "spots")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "min", nullable = false)
    private Integer min;

    @NotNull
    @Column(name = "max", nullable = false)
    private Integer max;

    @NotNull
    @Column(name = "available", nullable = false)
    private Integer available;

    @NotNull
    @Column(name = "taken", nullable = false)
    private Integer taken;

}