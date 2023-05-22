package ee.valiit.events.domain.time;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "\"time\"")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "date_created", nullable = false)
    private Instant dateCreated;

    @NotNull
    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "end_time")
    private LocalTime endTime;

}