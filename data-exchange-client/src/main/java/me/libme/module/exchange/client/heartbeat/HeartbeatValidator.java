package me.libme.module.exchange.client.heartbeat;

import me.libme.module.exchange.client.RequestValidator;

/**
 * Created by J on 2018/10/24.
 */
public class HeartbeatValidator extends RequestValidator<HeartbeatRequest> {

    @Override
    public boolean validate(HeartbeatRequest target) {
        super.validate(target);


        return  true;
    }
}
