package me.libme.module.exchange.client;

/**
 * Created by J on 2018/10/24.
 */
public interface Handler<T extends Request> {

    void handle(T request,Response response);

    static void noop(Request request,Response response){}

}
