package com.hrs.booking.entity;

import com.hrs.booking.constants.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

/**
 * The type Booking entity.
 */
@Entity
@Getter
@Setter
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel-sequence")
    @SequenceGenerator(name = "hotel-sequence", sequenceName = "hotel-sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private Long roomId;
    @NotNull
    private Long userId;

    private BookingStatus bookingStatus;
    private LocalDate checkIdDate;
    private LocalDate checkOutDate;
    @UpdateTimestamp
    private LocalDate bookingDate;
}
