package com.example.bookingms.domain.commands;

import lombok.*;

import java.util.Date;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
public class BookCargoCommand {
    String BookingId;
    @lombok.NonNull
    int bookingAmount;
    @lombok.NonNull
    String OriginLocation;
    @lombok.NonNull
    String DestLocation;
    @lombok.NonNull
    Date DestArrivalDeadline;
}
