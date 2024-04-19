package com.example.bookingms.domain.model.valueobjects;

import com.example.bookingms.domain.model.entities.Location;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

@Embeddable
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class CargoHandlingActivity {
    private static final long serialVersionUID = 1L;
    @Column(name = "next_expected_handling_event_type")
    @NonNull
    private String type;
    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "next_expected_location_id"))
    @NonNull
    private Location location;
    @Column(name = "next_expected_voyage_id")
    private Voyage voyage;
}
