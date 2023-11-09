package com.sportnet.platform.u202116113.booking.interfaces.rest.transform;

import com.sportnet.platform.u202116113.booking.domain.model.commands.CreateSportEventCommand;
import com.sportnet.platform.u202116113.booking.interfaces.rest.resources.CreateSportEventResource;

public class CreateSportEventCommandFromResourceAssembler {
    public static CreateSportEventCommand toCommandFromResource(CreateSportEventResource resource) {
        return new CreateSportEventCommand(resource.eventName(), resource.sportType(), resource.organizerId(), resource.location(), resource.capacity(), resource.eventDate());
    }
}
