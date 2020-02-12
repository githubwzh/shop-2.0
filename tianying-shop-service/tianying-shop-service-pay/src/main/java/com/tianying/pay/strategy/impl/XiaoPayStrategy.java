package com.tianying.pay.strategy.impl;


import com.tianying.pay.mapper.entity.PaymentChannelEntity;
import com.tianying.pay.output.dto.PayMentTransacDTO;
import com.tianying.pay.strategy.PayStrategy;

public class XiaoPayStrategy implements PayStrategy {

	@Override
	public String toPayHtml(PaymentChannelEntity pymentChannel, PayMentTransacDTO payMentTransacDTO) {

		return "小米支付from表单提交";
	}
	//com.mayikt.pay.strategy.impl.XiaoPayStrategy

}
