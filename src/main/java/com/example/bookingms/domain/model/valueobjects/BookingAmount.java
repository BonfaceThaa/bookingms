package com.example.bookingms.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingAmount {
    @Column(name = "booking_amount", unique = true, updatable = false)
    private Integer bookingAmount;
}
