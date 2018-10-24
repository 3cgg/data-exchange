package test.me.libme.module.exchange.client;

import me.libme.module.exchange.client.Sender;
import me.libme.module.exchange.client.heartbeat.HeartbeatRequest;

/**
 * Created by J on 2018/10/24.
 */
public class TestHeartbeatCommand {


    public static void main(String[] args) {

        HeartbeatRequest request=new HeartbeatRequest();
        request.setAk("ak");
        request.setDataSourceName("DSName");
        Sender.send(request);

    }

}
