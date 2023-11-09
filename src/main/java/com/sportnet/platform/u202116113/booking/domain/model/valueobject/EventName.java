package com.sportnet.platform.u202116113.booking.domain.model.valueobject;

import jakarta.persistence.Embeddable;

@Embeddable
public record EventName(String eventName) {
    public EventName(){
        this(null);
    }

    public EventName {
        if (eventName == null || eventName.isBlank()) {
            throw new IllegalArgumentException("Event name cannot be null or blank");
        }
    }
}
