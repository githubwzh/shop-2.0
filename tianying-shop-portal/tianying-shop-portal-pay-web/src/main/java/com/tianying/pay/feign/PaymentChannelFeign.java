package com.tianying.pay.feign;

import com.tianying.pay.service.PaymentChannelService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-tianying-pay")
public interface PaymentChannelFeign extends PaymentChannelService {

}
