package com.tianying.pay.service.impl;

import com.tianying.base.BaseApiService;
import com.tianying.mapper.MapperUtils;
import com.tianying.pay.mapper.entity.PaymentChannelEntity;
import com.tianying.pay.output.dto.PaymentChannelDTO;
import com.tianying.pay.service.PaymentChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentChannelServiceImpl extends BaseApiService<List<PaymentChannelDTO>>
		implements PaymentChannelService {
	@Autowired
	private com.tianying.pay.mapper.PaymentChannelMapper paymentChannelMapper;

	@Override
	public List<PaymentChannelDTO> selectAll() {
		List<PaymentChannelEntity> paymentChanneList = paymentChannelMapper.selectAll();
		return MapperUtils.mapAsList(paymentChanneList, PaymentChannelDTO.class);
	}

}
