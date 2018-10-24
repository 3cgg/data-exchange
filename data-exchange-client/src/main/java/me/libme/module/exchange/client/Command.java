package me.libme.module.exchange.client;

/**
 * Created by J on 2018/10/24.
 */
public interface Command<T extends Request> {


    void execute(T request,Handler handler);


}
