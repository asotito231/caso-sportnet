package com.sportnet.platform.u202116113.booking.domain.model.aggregates;

import com.sportnet.platform.u202116113.booking.domain.model.valueobject.EventName;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class SportEvent extends AbstractAggregateRoot<SportEvent> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Embedded
    private EventName eventName;
    @Getter
    private String sportType;
    @Getter
    private Long organizerId;
    @Getter
    private String location;
    @Getter
    @Positive
    private Integer capacity;
    @Getter
    private LocalDate eventDate;
    public SportEvent(String eventName, String sportType, Long organizerId, String location, Integer capacity, LocalDate eventDate) {
        this.eventName = new EventName(eventName);
        this.sportType = sportType;
        this.location = location;
        this.organizerId = organizerId;
        this.capacity = capacity;
        this.eventDate = eventDate;
    }

    public SportEvent() {

    }

    public String getEventName() {
        return this.eventName.eventName();
    }
}
