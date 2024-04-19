package com.example.bookingms.interfaces.rest.transform;

import com.example.bookingms.domain.commands.BookCargoCommand;
import com.example.bookingms.interfaces.rest.dto.BookingCargoResource;

import java.sql.Date;

public class BookCargoCommandDTOAssembler {
    public BookCargoCommand toCommandFromDTO(BookingCargoResource bookingCargoResource) {
        return new BookCargoCommand(bookingCargoResource.getBookingAmount(),
                bookingCargoResource.getOriginLocation(),
                bookingCargoResource.getDestinationLocation(),
                Date.valueOf(bookingCargoResource.getDestArrivalDate()));
    }
}
