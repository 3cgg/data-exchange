package me.libme.module.exchange.client.heartbeat;

import me.libme.kernel._c.http.JHttp;
import me.libme.module.exchange.client.Command;
import me.libme.module.exchange.client.Config;
import me.libme.module.exchange.client.Cons;
import me.libme.module.exchange.client.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by J on 2018/10/24.
 */
public class HeartbeatCommand implements Command<HeartbeatRequest> {

    private static final Logger LOGGER= LoggerFactory.getLogger(HeartbeatCommand.class);

    private HeartbeatValidator heartbeatValidator=new HeartbeatValidator();

    @Override
    public void execute(HeartbeatRequest request, Handler handler) {

        request.initClient(Config.client());

        heartbeatValidator.validate(request);

        try {
            JHttp._post()
                    .putHead("Content-Type","application/json")
                    .putHead(Cons.HeadNames.ACCESS_KEY,request.getAk())
//                    .putHead(Cons.DATASOURCE_CODE,request.getDataSourceCode())
                    .putHead(Cons.HeadNames.DATASOURCE_NAME,request.getDataSourceName())
                    .putHead(Cons.HeadNames.REQUEST_TYPE, Cons.HeadValues.HEARTBEAT)
                    .execute(Config.server().getHost()+Config.server().getPrefix()+"/heartBeat");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
        }


    }


}
