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

    @Query("SELECT e FROM Event e LEFT JOIN FETCH e.address a WHERE e.eventDate >= :currentDate")
    public Page<Event> findUpComingEvents(@Param("currentDate")Date currentDate, Pageable pageable);

    @Query("SELECT e FROM Event e " +
            "LEFT JOIN FETCH e.address a " +
            "WHERE (:title = '' OR e.title LIKE %:title%) " +
            "AND (:city = '' OR a.city LIKE %:city%) " +
            "AND (:uf = '' OR a.uf LIKE %:uf%) " +
            "AND (e.eventDate >= :startDate AND e.eventDate <= :endDate)")
    Page<Event> getFilteredEvents(@Param("title") String title,
                                   @Param("city") String city,
                                   @Param("uf") String uf,
                                   @Param("startDate") Date startDate,
                                   @Param("endDate") Date endDate,
                                   Pageable pageable);
}
