package com.example.bookingms.infrastructure.repositories;

import com.example.bookingms.application.internal.aggregates.BookingId;
import com.example.bookingms.application.internal.aggregates.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CargoRepository extends JpaRepository <Cargo, Long> {
    Cargo findByBookingId(BookingId bookingId);
    List<BookingId> findAllBookingIds();
    List<Cargo> findAll();
}
