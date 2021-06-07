package com.common.test.demo44_guavaEventBus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: fans
 * @Date: 2021/5/26 21:43
 * @Desc:
 */
@Data
@AllArgsConstructor
public class PaymentSuccessfulEvent {
    private String action;
}
