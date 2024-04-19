package com.example.bookingms.application.internal.aggregates;


import com.example.bookingms.domain.commands.BookCargoCommand;
import com.example.bookingms.domain.model.valueobjects.*;
import com.example.bookingms.domain.model.entities.Location;
import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Cargo.findAll",
                query = "Select c from Cargo c"),
        @NamedQuery(name = "Cargo.findByBookingId",
                query = "Select c from Cargo c where c.bookingId = :bookingId"),
        @NamedQuery(name = "Cargo.findAllBookingIds",
                query = "Select c.bookingId from Cargo c") })
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Embedded
    private BookingId bookingId;
    @Embedded
    private BookingAmount bookingAmount;
    @Embedded
    private Location origin;
    private RouteSpecification routeSpecification;
    @Embedded
    private CargoItinerary itinerary;
    @Embedded
    private Delivery delivery;

    public BookingId getBookingId() {
        return bookingId;
    }

    public Cargo() {
    }

    public Cargo(BookCargoCommand bookCargoCommand){
        this.bookingId = new BookingId(bookCargoCommand.getBookingId());
        this.routeSpecification = new RouteSpecification(
                new Location(bookCargoCommand.getOriginLocation()),
                new Location(bookCargoCommand.getDestLocation()),
                bookCargoCommand.getDestArrivalDeadline()
        );
        this.origin = routeSpecification.getOrigin();
        this.itinerary = CargoItinerary.EMPTY_ITINERARY; //Empty Itinerary since the Cargo has not been routed yet
        this.bookingAmount = new BookingAmount(bookCargoCommand.getBookingAmount());
        this.delivery = Delivery.derivedFrom(this.routeSpecification,
                this.itinerary, LastCargoHandledEvent.EMPTY);
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getOrigin() {
        return origin;
    }

    public RouteSpecification getRouteSpecification() {
        return this.routeSpecification;
    }


    public BookingAmount getBookingAmount(){
        return this.bookingAmount;
    }

    public void setBookingAmount(BookingAmount bookingAmount){
        this.bookingAmount = bookingAmount;
    }

    public CargoItinerary getcargoItinerary() {
        return this.itinerary;
    }
}
