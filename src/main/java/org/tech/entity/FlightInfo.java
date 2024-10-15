package org.tech.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "flight_info")
public class FlightInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Integer flightId;

    @Column(name = "flight_number", length = 20, nullable = false)
    private String flightNumber;

    @Column(name = "departure_airport", length = 15, nullable = false)
    private String departureAirport;

    @Column(name = "arrival_airport", length = 15, nullable = false)
    private String arrivalAirport;

    @Column(name = "scheduled_departure", nullable = false)
    private LocalDateTime scheduledDeparture;

    @Column(name = "actual_departure")
    private LocalDateTime actualDeparture;

    @Column(name = "scheduled_arrival", nullable = false)
    private LocalDateTime scheduledArrival;

    @Column(name = "actual_arrival")
    private LocalDateTime actualArrival;

    @Enumerated(EnumType.STRING)
    @Column(name = "flight_status", nullable = false)
    private FlightStatus flightStatus;

    @Column(name = "aircraft_type", length = 50)
    private String aircraftType;

    @Column(name = "gate_number", length = 20)
    private String gateNumber;

    @Column(name = "refresh_timestamp", nullable = false)
    private LocalDateTime refreshTimestamp;

    @Column(name = "next_refresh_time")
    private LocalDateTime nextRefreshTime;

    @Column(name = "api_request_count")
    private Integer apiRequestCount;

    @Column(name = "last_api_request_time")
    private LocalDateTime lastApiRequestTime;

}
