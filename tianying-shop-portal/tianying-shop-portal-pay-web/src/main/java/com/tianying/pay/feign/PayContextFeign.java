package com.tianying.pay.feign;

import com.tianying.pay.service.PayContextService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-tianying-pay")
public interface PayContextFeign extends PayContextService {

}
