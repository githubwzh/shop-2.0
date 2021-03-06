package com.tianying.pay.compensation.strategy;


import com.tianying.pay.mapper.entity.PaymentChannelEntity;
import com.tianying.pay.mapper.entity.PaymentTransactionEntity;

/**
 * 对账抽象策略角色
 *
 * @version V1.0
 * @description:
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 * 私自分享视频和源码属于违法行为。
 */
public interface PaymentCompensationStrategy {
    /**
     * 渠道名称
     *
     * @return
     */
    public Boolean payMentCompensation(PaymentTransactionEntity paymentTransaction, PaymentChannelEntity paymentChanne);
}
