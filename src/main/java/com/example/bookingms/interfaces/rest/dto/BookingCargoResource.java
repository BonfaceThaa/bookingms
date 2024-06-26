package com.example.bookingms.interfaces.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingCargoResource {
    int bookingAmount;
    String OriginLocation;
    String DestinationLocation;
    LocalDate DestArrivalDate;
}
