package com.sportnet.platform.u202116113.booking.interfaces.rest.transform;

import com.sportnet.platform.u202116113.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202116113.booking.interfaces.rest.resources.SportEventResource;

public class SportEventResourceFromEntityAssembler {
    public static SportEventResource toResourceFromEntity(SportEvent sportEvent) {
        return new SportEventResource(sportEvent.getId(), sportEvent.getEventName(), sportEvent.getSportType(), sportEvent.getOrganizerId(), sportEvent.getLocation(), sportEvent.getCapacity(), sportEvent.getEventDate());
    }
}
