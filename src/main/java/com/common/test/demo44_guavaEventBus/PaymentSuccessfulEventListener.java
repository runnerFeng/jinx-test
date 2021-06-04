package com.common.test.demo44_guavaEventBus;

import com.google.common.eventbus.Subscribe;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fans
 * @Date: 2021/5/26 21:45
 * @Desc:
 */
@Data
@Slf4j
public class PaymentSuccessfulEventListener{

    private int eventHandled;

    @Subscribe
    public void paymentEvent(PaymentSuccessfulEvent event){
        log.info("event action:{}",event.getAction());
        eventHandled++;
    }

}
