package com.example.bookingms.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingCargoCommand {
    String BookingId;
    int bookingAmount;
    String OriginLocation;
    String DestinationLocation;
    Date DestArrivalDate;
}
