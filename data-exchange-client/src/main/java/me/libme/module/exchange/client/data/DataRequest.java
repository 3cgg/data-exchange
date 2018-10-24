package me.libme.module.exchange.client.data;

import me.libme.module.exchange.client.Request;

/**
 * Created by J on 2018/10/24.
 */
public class DataRequest extends Request {

    /**
     * json string
     */
    private String body;

    private String queue;

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
