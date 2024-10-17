package org.tech.dto.request;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tech.entity.FlightStatus;
import org.tech.service.FlightInfoService;
import org.tech.xmlModel.xml.AIDXFlightLeg;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ApplicationScoped
@Named("flightInfoRequest")
public class FlightInfoRequest {

    @Inject
    private FlightInfoService flightInfoService;

    private String flightNumber;

    private String departureAirport;

    private String arrivalAirport;

    private LocalDateTime scheduledDeparture;

    private LocalDateTime actualDeparture;

    private LocalDateTime scheduledArrival;

    private LocalDateTime actualArrival;

    private FlightStatus flightStatus;

    private String aircraftType;

    private String gateNumber;

    private LocalDateTime refreshTimestamp;

    private LocalDateTime nextRefreshTime;

    private Integer apiRequestCount;

    private LocalDateTime lastApiRequestTime;

    public FlightInfoRequest convertToFlightInfoRequest(AIDXFlightLeg flight) {
        FlightInfoRequest flightInfoRequest = new FlightInfoRequest();
        flightInfoRequest.setFlightNumber(flight.getFlightLeg().getFlightNumber());
        flightInfoRequest.setActualDeparture(LocalDateTime.now());
        flightInfoRequest.setDepartureAirport(flight.getFlightLeg().getDeparture().getAirport().getIata().toUpperCase() + " / " + flight.getFlightLeg().getDeparture().getAirport().getIcao().toUpperCase());
        flightInfoRequest.setArrivalAirport(flight.getFlightLeg().getArrival().getAirport().getIata().toUpperCase() + " / " + flight.getFlightLeg().getDeparture().getAirport().getIcao().toUpperCase());
       // Local Date Parse
        flightInfoRequest.setScheduledDeparture(LocalDateTime.parse(flight.getFlightLeg().getDeparture().getScheduledDateTime()));
        // Local Date Parse
        flightInfoRequest.setScheduledArrival(LocalDateTime.parse(flight.getFlightLeg().getArrival().getScheduledDateTime()));
        // Local Date Parse
        flightInfoRequest.setActualArrival(LocalDateTime.parse(flight.getFlightLeg().getOperationalTimes().getActualOnBlockTime()));
        flightInfoRequest.setFlightStatus(FlightStatus.Arrived);
        flightInfoRequest.setAircraftType(flight.getFlightLeg().getAircraft().getType());
        flightInfoRequest.setGateNumber(flight.getFlightLeg().getAircraft().getRegistration());
        flightInfoRequest.setRefreshTimestamp(LocalDateTime.now());
        flightInfoRequest.setNextRefreshTime(LocalDateTime.now());
        flightInfoRequest.setApiRequestCount(5);
        flightInfoRequest.setLastApiRequestTime(LocalDateTime.now());

        flightInfoService.addFlightRecord(flightInfoRequest);
        return flightInfoRequest;
    }
}
