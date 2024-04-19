package com.example.bookingms.domain.model.valueobjects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CargoItinerary {
    public static final CargoItinerary EMPTY_ITINERARY = new CargoItinerary();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargo_id")
    @OrderBy
    private List<Leg> legs = Collections.emptyList();
}
