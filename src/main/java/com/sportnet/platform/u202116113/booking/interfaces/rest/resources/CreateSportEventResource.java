package com.sportnet.platform.u202116113.booking.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateSportEventResource(String eventName, String sportType, Long organizerId, String location, Integer capacity, LocalDate eventDate) {
}
