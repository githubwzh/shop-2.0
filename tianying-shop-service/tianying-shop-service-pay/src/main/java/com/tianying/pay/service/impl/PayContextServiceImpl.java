package com.tianying.pay.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.tianying.base.BaseApiService;
import com.tianying.base.BaseResponse;
import com.tianying.pay.factory.StrategyFactory;
import com.tianying.pay.mapper.PaymentChannelMapper;
import com.tianying.pay.mapper.entity.PaymentChannelEntity;
import com.tianying.pay.output.dto.PayMentTransacDTO;
import com.tianying.pay.service.PayContextService;
import com.tianying.pay.service.PayMentTransacInfoService;
import com.tianying.pay.strategy.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class
PayContextServiceImpl extends BaseApiService<JSONObject> implements PayContextService {
	@Autowired
	private PaymentChannelMapper paymentChannelMapper;
	@Autowired
	private PayMentTransacInfoService payMentTransacInfoService;

	@Override
	public BaseResponse<JSONObject> toPayHtml(String channelId, String payToken) {

		// 1.使用渠道id获取渠道信息 classAddres
		PaymentChannelEntity pymentChannel = paymentChannelMapper.selectBychannelId(channelId);
		if (pymentChannel == null) {
			return setResultError("没有查询到该渠道信息");
		}
		// 2.使用payToken获取支付参数
		BaseResponse<PayMentTransacDTO> tokenByPayMentTransac = payMentTransacInfoService
				.tokenByPayMentTransac(payToken);
		if (!isSuccess(tokenByPayMentTransac)) {
			return setResultError(tokenByPayMentTransac.getMsg());
		}
		PayMentTransacDTO payMentTransacDTO = tokenByPayMentTransac.getData();
		// 3.执行具体的支付渠道的算法获取html表单数据 策略设计模式 使用java反射机制 执行具体方法
		String classAddres = pymentChannel.getClassAddres();
		PayStrategy payStrategy = StrategyFactory.getPayStrategy(classAddres);
		String payHtml = payStrategy.toPayHtml(pymentChannel, payMentTransacDTO);
		// 4.直接返回html
		JSONObject data = new JSONObject();
		data.put("payHtml", payHtml);
		return setResultSuccess(data);
	}

}
