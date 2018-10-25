package me.libme.module.exchange.client.data;

import me.libme.kernel._c.util.Assert;
import me.libme.kernel._c.util.JStringUtils;
import me.libme.module.exchange.client.RequestValidator;

/**
 * Created by J on 2018/10/24.
 */
public class DataValidator extends RequestValidator<DataRequest> {

    @Override
    public boolean validate(DataRequest target) {
        super.validate(target);
        Assert.isTrue(JStringUtils.isNotNullOrEmpty(target.getQueue()),"queue is missing.");
        Assert.isTrue(JStringUtils.isNotNullOrEmpty(target.getBody()),"body is empty.");
        return  true;
    }
}
