package org.tech.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.tech.entity.FlightInfo;

@ApplicationScoped
public class FlightInfoRepository implements PanacheRepository<FlightInfo>{
}
