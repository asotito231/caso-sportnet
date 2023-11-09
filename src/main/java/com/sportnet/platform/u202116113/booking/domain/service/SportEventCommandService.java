package com.sportnet.platform.u202116113.booking.domain.service;

import com.sportnet.platform.u202116113.booking.domain.model.commands.CreateSportEventCommand;

public interface SportEventCommandService {
    Long handle(CreateSportEventCommand command);
}
