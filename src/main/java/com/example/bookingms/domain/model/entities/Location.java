package com.example.bookingms.domain.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {
    @Column(name = "origin_id", insertable=false, updatable=false)
    private String unLocCode;
}
