package com.eventostech.api.service;

import com.eventostech.api.domain.coupon.Coupon;
import com.eventostech.api.domain.coupon.CouponRequestDTO;
import com.eventostech.api.domain.event.Event;
import com.eventostech.api.repositories.CouponRepository;
import com.eventostech.api.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventRepository eventRepository;

    public Coupon addCouponToEvent(UUID eventId, CouponRequestDTO couponData) {

        Event event = eventRepository.getReferenceById(eventId);

        Coupon newCoupon = new Coupon();

        newCoupon.setCode(couponData.code());
        newCoupon.setDiscount(couponData.discount());
        newCoupon.setEvent(event);


        Timestamp couponStamp = new Timestamp(couponData.valid());
        Date couponDate = new Date(couponStamp.getTime());
        newCoupon.setValid(couponDate);

        return couponRepository.save(newCoupon);
    }
}
