package com.example.bookingms.application.internal.commandservices;

import com.example.bookingms.application.internal.aggregates.BookingId;
import com.example.bookingms.application.internal.aggregates.Cargo;
import com.example.bookingms.domain.commands.BookCargoCommand;
import com.example.bookingms.infrastructure.repositories.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingCommandService {

    private final CargoRepository cargoRepository;

    public BookingCommandService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public BookingId bookCargo(BookCargoCommand bookingCargoCommand) {

        String randomId = UUID.randomUUID().toString().toUpperCase();
        bookingCargoCommand.setBookingId(randomId);
        Cargo cargo = new Cargo(bookingCargoCommand);
        cargoRepository.save(cargo);

        return new BookingId(randomId);
    }
}
