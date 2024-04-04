package com.example.bookingms.interfaces.rest;

import com.example.bookingms.application.internal.aggregates.BookingId;
import com.example.bookingms.application.internal.commandservices.BookingCommandService;
import com.example.bookingms.interfaces.rest.dto.BookingCargoResource;
import com.example.bookingms.interfaces.rest.transform.BookCargoCommandDTOAssembler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargobooking")
public class CargoBookingController {

    private  BookingCommandService bookingCommandService;

    public CargoBookingController(BookingCommandService bookingCommandService) {
        this.bookingCommandService = bookingCommandService;
    }

    @PostMapping
    @ResponseBody
    public BookingId bookCargo(@RequestBody BookingCargoResource bookingCargoResource){
        BookCargoCommandDTOAssembler bookCargoCommandDTOAssembler = new BookCargoCommandDTOAssembler();
        return bookingCommandService.bookCargo(bookCargoCommandDTOAssembler.toCommandFromDTO(bookingCargoResource));
    }

}
