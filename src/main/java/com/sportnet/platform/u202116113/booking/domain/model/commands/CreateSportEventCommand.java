package com.sportnet.platform.u202116113.booking.domain.model.commands;

import java.time.LocalDate;

public record CreateSportEventCommand(String eventName, String sportType, Long organizerId, String location, Integer capacity, LocalDate eventDate) {
}