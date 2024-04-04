package com.example.bookingms.application.internal.commandservices;

import com.example.bookingms.application.internal.aggregates.BookingId;
import com.example.bookingms.domain.commands.BookingCargoCommand;

import java.util.UUID;

public class BookingCommandService {
    public BookingId bookCargo(BookingCargoCommand bookingCargoCommand) {
        String randomId = UUID.randomUUID().toString().toUpperCase();
        bookingCargoCommand.setBookingId(randomId);

        return new BookingId(randomId);
    }
}
