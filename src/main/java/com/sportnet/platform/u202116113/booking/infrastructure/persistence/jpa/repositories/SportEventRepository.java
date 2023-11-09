package com.sportnet.platform.u202116113.booking.infrastructure.persistence.jpa.repositories;

import com.sportnet.platform.u202116113.booking.domain.model.aggregates.SportEvent;
import com.sportnet.platform.u202116113.booking.domain.model.valueobject.EventName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SportEventRepository extends JpaRepository<SportEvent, Long> {
    Optional<SportEvent> findByEventNameAndLocationAndSportType(EventName eventName, String location, String sportType);
    Optional<SportEvent> findByOrganizerIdAndEventDate(Long organizerId, LocalDate eventDate);
}
