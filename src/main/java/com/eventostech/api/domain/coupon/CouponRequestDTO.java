package com.eventostech.api.domain.coupon;

import java.util.Date;
import java.util.UUID;

public record CouponRequestDTO (String code, Integer discount, Long valid){
}
