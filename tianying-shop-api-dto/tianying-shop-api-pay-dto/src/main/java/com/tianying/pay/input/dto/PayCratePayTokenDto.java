package com.tianying.pay.input.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PayCratePayTokenDto {
    /**
     * 支付金额
     */
    @NotNull(message = "支付金额不能为空")
    private Long payAmount;
    /**
     * 订单号码
     */
    @NotNull(message = "订单号码不能为空")
    private String orderId;

    /**
     * userId
     */
    @NotNull(message = "userId不能空")
    private Long userId;
    /**
     * 订单描述
     */
    @NotNull(message = "订单描述")
    private String orderDes;
}
