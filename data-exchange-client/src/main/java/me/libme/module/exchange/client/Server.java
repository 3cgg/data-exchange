package me.libme.module.exchange.client;

/**
 * Created by J on 2018/10/24.
 */
public class Server {

    private String host;

    private String prefix="/scc/exchange/httpApi";

    Server() {
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }



}
