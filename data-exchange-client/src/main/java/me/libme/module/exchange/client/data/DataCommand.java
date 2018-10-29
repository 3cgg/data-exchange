package me.libme.module.exchange.client.data;

import me.libme.kernel._c.http.JHttp;
import me.libme.module.exchange.client.Command;
import me.libme.module.exchange.client.Config;
import me.libme.module.exchange.client.Cons;
import me.libme.module.exchange.client.Handler;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * Created by J on 2018/10/24.
 */
public class DataCommand implements Command<DataRequest> {

    private static final Logger LOGGER= LoggerFactory.getLogger(DataCommand.class);

    private DataValidator dataValidator=new DataValidator();

    @Override
    public void execute(DataRequest request, Handler handler) {

        request.initClient(Config.client());

        dataValidator.validate(request);

        try {
            StringEntity stringEntity=new StringEntity(request.getBody(), Charset.forName("utf-8"));
            JHttp._post()
                    .putHead("Content-Type","application/json")
                    .putHead(Cons.HeadNames.ACCESS_KEY,request.getAk())
//                    .putHead(Cons.DATASOURCE_CODE,request.getDataSourceCode())
                    .putHead(Cons.HeadNames.DATASOURCE_NAME,request.getDataSourceName())
                    .putHead(Cons.HeadNames.QUEUE,request.getQueue())
                    .putHead(Cons.HeadNames.REQUEST_TYPE, Cons.HeadValues.HEARTBEAT+"|"+ Cons.HeadValues.DATA)
                    .setEntity(stringEntity)
                    .execute(Config.server().getHost()+Config.server().getPrefix()+"/collect");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
        }


    }


}
