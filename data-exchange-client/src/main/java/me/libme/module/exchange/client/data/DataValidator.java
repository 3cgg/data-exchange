package me.libme.module.exchange.client.data;

import me.libme.module.exchange.client.RequestValidator;

/**
 * Created by J on 2018/10/24.
 */
public class DataValidator extends RequestValidator<DataRequest> {

    @Override
    public boolean validate(DataRequest target) {
        super.validate(target);


        return  true;
    }
}
