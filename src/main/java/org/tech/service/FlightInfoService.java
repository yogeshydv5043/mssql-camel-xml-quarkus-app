package org.tech.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.tech.dto.request.FlightInfoRequest;
import org.tech.entity.FlightInfo;
import org.tech.repository.FlightInfoRepository;

import java.util.List;

@ApplicationScoped
public class FlightInfoService {

    @Inject
    private FlightInfoRepository flightInfoRepository;


    @Transactional
    public String addFlightRecord(FlightInfoRequest flightInfoRequest) {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setFlightNumber(flightInfoRequest.getFlightNumber());
        flightInfo.setDepartureAirport(flightInfoRequest.getDepartureAirport());
        flightInfo.setArrivalAirport(flightInfoRequest.getArrivalAirport());
        flightInfo.setActualDeparture(flightInfoRequest.getActualDeparture());
        flightInfo.setScheduledDeparture(flightInfoRequest.getScheduledDeparture());
        flightInfo.setScheduledArrival(flightInfoRequest.getScheduledArrival());
        flightInfo.setActualArrival(flightInfoRequest.getActualArrival());
        flightInfo.setFlightStatus(flightInfoRequest.getFlightStatus());
        flightInfo.setAircraftType(flightInfoRequest.getAircraftType());
        flightInfo.setGateNumber(flightInfoRequest.getGateNumber());
        flightInfo.setRefreshTimestamp(flightInfoRequest.getRefreshTimestamp());
        flightInfo.setNextRefreshTime(flightInfoRequest.getNextRefreshTime());
        flightInfo.setApiRequestCount(flightInfoRequest.getApiRequestCount());
        flightInfo.setLastApiRequestTime(flightInfoRequest.getLastApiRequestTime());

        flightInfoRepository.persist(flightInfo);

        return "Record saving successfully";
    }

    public List<FlightInfo> getAllRecord() {
        return flightInfoRepository.findAll().list();
    }

    @Transactional
    public String deleteRecord(Long id) {
        boolean isDeleted = flightInfoRepository.deleteById(id);
        return isDeleted ? "Record deleted successfully: " + id
                : "Failed to delete Record with ID: " + id;
    }
}
