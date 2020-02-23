package com.tianying.pay.feign;

import com.tianying.pay.service.PayMentTransacInfoService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-tianying-pay")
public interface PayMentTransacInfoFeign extends PayMentTransacInfoService {

}
