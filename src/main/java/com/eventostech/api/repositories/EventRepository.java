package com.eventostech.api.repositories;

import com.eventostech.api.domain.event.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

    @Query("SELECT e FROM Event e WHERE e.eventDate >= :currentDate")
    public Page<Event> findUpComingEvents(@Param("currentDate")Date currentDate, Pageable pageable);
}
