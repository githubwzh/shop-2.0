package com.tianying.pay.mapper;

import com.tianying.pay.mapper.entity.PaymentTransactionLogEntity;
import org.apache.ibatis.annotations.Insert;

public interface PaymentTransactionLogMapper {

    @Insert("INSERT INTO `payment_transaction_log` VALUES (NULL, NULL, #{asyncLog},NULL, #{transactionId}, null, null, NOW(), null, NOW());")
    public int insertTransactionLog(PaymentTransactionLogEntity paymentTransactionLog);

}
