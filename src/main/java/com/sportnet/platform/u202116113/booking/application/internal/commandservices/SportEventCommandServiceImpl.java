package com.sportnet.platform.u202116113.booking.application.internal.commandservices;

import com.sportnet.platform.u202116113.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202116113.booking.domain.model.commands.CreateSportEventCommand;
import com.sportnet.platform.u202116113.booking.domain.model.valueobject.EventName;
import com.sportnet.platform.u202116113.booking.domain.service.SportEventCommandService;
import com.sportnet.platform.u202116113.booking.infrastructure.persistence.jpa.repositories.SportEventRepository;
import org.springframework.stereotype.Service;

@Service
public class SportEventCommandServiceImpl implements SportEventCommandService {
    private final SportEventRepository sportEventRepository;

    public SportEventCommandServiceImpl(SportEventRepository sportEventRepository) {
        this.sportEventRepository = sportEventRepository;
    }

    @Override
    public Long handle(CreateSportEventCommand command) {
        var eventName = new EventName(command.eventName());
        sportEventRepository.findByEventNameAndLocationAndSportType(eventName, command.location(), command.sportType()).map(sportEvent -> {
            throw new IllegalArgumentException("Sport event already exists");
        });

        sportEventRepository.findByOrganizerIdAndEventDate(command.organizerId(), command.eventDate()).map(sportEvent -> {
            throw new IllegalArgumentException("Organizer already has an event on this date");
        });

        if (command.capacity() <= 0)
            throw new IllegalArgumentException("Capacity must be positive");

        var sportEvent = new SportEvent(
                command.eventName(),
                command.sportType(),
                command.organizerId(),
                command.location(),
                command.capacity(),
                command.eventDate()
        );
        sportEventRepository.save(sportEvent);
        return sportEvent.getId();
    }
}
