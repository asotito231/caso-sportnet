package com.sportnet.platform.u202116113.booking.domain.service;

import com.sportnet.platform.u202116113.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202116113.booking.domain.model.queries.GetSportEventByIdQuery;

import java.util.Optional;

public interface SportEventQueryService {
    Optional<SportEvent> handle(GetSportEventByIdQuery query);
}
