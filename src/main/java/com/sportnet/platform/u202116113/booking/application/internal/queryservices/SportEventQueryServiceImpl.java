package com.sportnet.platform.u202116113.booking.application.internal.queryservices;

import com.sportnet.platform.u202116113.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202116113.booking.domain.model.queries.GetSportEventByIdQuery;
import com.sportnet.platform.u202116113.booking.domain.service.SportEventQueryService;
import com.sportnet.platform.u202116113.booking.infrastructure.persistence.jpa.repositories.SportEventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SportEventQueryServiceImpl implements SportEventQueryService {
    private final SportEventRepository sportEventRepository;

    public SportEventQueryServiceImpl(SportEventRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
    }

    @Override
    public Optional<SportEvent> handle(GetSportEventByIdQuery query) {
        return sportEventRepository.findById(query.id());
    }
}
