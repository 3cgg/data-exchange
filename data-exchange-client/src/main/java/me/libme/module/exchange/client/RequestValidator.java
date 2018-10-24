package me.libme.module.exchange.client;

import me.libme.kernel._c._i.SimpleValiator;
import me.libme.kernel._c.util.Assert;
import me.libme.kernel._c.util.JStringUtils;

/**
 * Created by J on 2018/10/24.
 */
public class RequestValidator<T extends Request> implements SimpleValiator<T>{


    @Override
    public boolean validate(T target) {

        Assert.state(JStringUtils.isNotNullOrEmpty(target.getAk()),"ak is missing.");
//        Assert.state(JStringUtils.isNotNullOrEmpty(target.getDataSourceCode()),"data source code is missing.");
        Assert.state(JStringUtils.isNotNullOrEmpty(target.getDataSourceName()),"data source name is missing.");

        return true;
    }



}
