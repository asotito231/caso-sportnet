package com.sportnet.platform.u202116113.booking.interfaces.rest;


import com.sportnet.platform.u202116113.booking.domain.model.queries.GetSportEventByIdQuery;
import com.sportnet.platform.u202116113.booking.domain.service.SportEventCommandService;
import com.sportnet.platform.u202116113.booking.domain.service.SportEventQueryService;
import com.sportnet.platform.u202116113.booking.interfaces.rest.resources.CreateSportEventResource;
import com.sportnet.platform.u202116113.booking.interfaces.rest.resources.SportEventResource;
import com.sportnet.platform.u202116113.booking.interfaces.rest.transform.CreateSportEventCommandFromResourceAssembler;
import com.sportnet.platform.u202116113.booking.interfaces.rest.transform.SportEventResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/sportevents", produces = MediaType.APPLICATION_JSON_VALUE)
public class SportEventController {
    private final SportEventQueryService sportEventQueryService;
    private final SportEventCommandService sportEventCommandService;

    public SportEventController(SportEventQueryService sportEventQueryService, SportEventCommandService sportEventCommandService) {
        this.sportEventQueryService = sportEventQueryService;
        this.sportEventCommandService = sportEventCommandService;
    }

    @PostMapping
    public ResponseEntity<SportEventResource> CreateSportEvent(@RequestBody CreateSportEventResource resource) {
        var createSportEventCommand = CreateSportEventCommandFromResourceAssembler.toCommandFromResource(resource);
        var sportEventId = sportEventCommandService.handle(createSportEventCommand);
        if (sportEventId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getSportEventByIdQuery = new GetSportEventByIdQuery(sportEventId);
        var sportEvent = sportEventQueryService.handle(getSportEventByIdQuery);
        if (sportEvent.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var sportEventResource = SportEventResourceFromEntityAssembler.toResourceFromEntity(sportEvent.get());
        return new ResponseEntity<>(sportEventResource, HttpStatus.CREATED);
    }
}
