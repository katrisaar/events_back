package ee.valiit.events.domain.address;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "addressxcoordinate", precision = 6, scale = 4)
    private BigDecimal addressxcoordinate;

    @Column(name = "addressycoordinate", precision = 6, scale = 4)
    private BigDecimal addressycoordinate;
}