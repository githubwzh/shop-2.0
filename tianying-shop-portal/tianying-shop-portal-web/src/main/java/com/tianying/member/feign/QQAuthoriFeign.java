package com.tianying.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.tianying.member.api.service.QQAuthoriService;


@FeignClient("app-tianying-member")
public interface QQAuthoriFeign extends QQAuthoriService {

}
