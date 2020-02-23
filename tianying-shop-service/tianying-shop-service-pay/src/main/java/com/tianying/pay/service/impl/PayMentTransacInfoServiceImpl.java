package com.tianying.pay.service.impl;

import com.tianying.base.BaseApiService;
import com.tianying.base.BaseResponse;
import com.tianying.core.bean.MeiteBeanUtils;
import com.tianying.core.token.GenerateToken;
import com.tianying.pay.mapper.PaymentTransactionMapper;
import com.tianying.pay.mapper.entity.PaymentTransactionEntity;
import com.tianying.pay.output.dto.PayMentTransacDTO;
import com.tianying.pay.service.PayMentTransacInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayMentTransacInfoServiceImpl extends BaseApiService<PayMentTransacDTO>
        implements PayMentTransacInfoService {
    @Autowired
    private GenerateToken generateToken;
    @Autowired
    private PaymentTransactionMapper paymentTransactionMapper;

    @Override
    public BaseResponse<PayMentTransacDTO> tokenByPayMentTransac(String token) {
        // 1.验证token是否为空
        if (StringUtils.isEmpty(token)) {
            return setResultError("token参数不能空!");
        }
        // 2.使用token查询redisPayMentTransacID
        String value = generateToken.getToken(token);
        if (StringUtils.isEmpty(value)) {
            return setResultError("该Token可能已经失效或者已经过期");
        }
        // 3.转换为整数类型
        Long transactionId = Long.parseLong(value);
        // 4.使用transactionId查询支付信息
        PaymentTransactionEntity paymentTransaction = paymentTransactionMapper.selectById(transactionId);
        if (paymentTransaction == null) {
            return setResultError("未查询到该支付信息");
        }
        return setResultSuccess(MeiteBeanUtils.doToDto(paymentTransaction, PayMentTransacDTO.class));
    }

}
