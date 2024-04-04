package com.example.bookingms.interfaces.rest.transform;

import com.example.bookingms.domain.commands.BookingCargoCommand;
import com.example.bookingms.interfaces.rest.dto.BookingCargoResource;

import java.sql.Date;

public class BookCargoCommandDTOAssembler {
    public BookingCargoCommand toCommandFromDTO(BookingCargoResource bookingCargoResource) {
        return new BookingCargoCommand(bookingCargoResource.getBookingAmount(),
                bookingCargoResource.getOriginLocation(),
                bookingCargoResource.getDestinationLocation(),
                Date.valueOf(bookingCargoResource.getDestArrivalDate()));
    }
}
