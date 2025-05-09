package com.eventostech.api.domain.event;
import java.util.Date;
import java.util.UUID;

import com.eventostech.api.domain.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "events")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private String imgUrl;
    private String eventUrl;
    private Boolean remote;
    private Date eventDate;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    private Address address;

}
