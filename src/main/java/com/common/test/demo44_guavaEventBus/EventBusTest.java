package com.common.test.demo44_guavaEventBus;

import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fans
 * @Date: 2021/5/26 21:48
 * @Desc:
 */
@Slf4j
public class EventBusTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus("sortTest");
        PaymentSuccessfulEventListener listener = new PaymentSuccessfulEventListener();
        eventBus.register(listener);

        PaymentSuccessfulEvent event = new PaymentSuccessfulEvent("payment successful");
        eventBus.post(event);

        log.info("listener handler:{}",listener.getEventHandled());
    }
}
