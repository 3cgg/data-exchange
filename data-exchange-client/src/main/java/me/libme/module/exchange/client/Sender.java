package me.libme.module.exchange.client;

import me.libme.kernel._c.async.SimpleThreadPoolExecutorFactory;
import me.libme.kernel._c.async.Task;
import me.libme.kernel._c.async.TaskExecutor;
import me.libme.kernel._c.async.ThreadConfig;
import me.libme.module.exchange.client.data.DataCommand;
import me.libme.module.exchange.client.data.DataRequest;
import me.libme.module.exchange.client.heartbeat.HeartbeatCommand;
import me.libme.module.exchange.client.heartbeat.HeartbeatRequest;

/**
 * Created by J on 2018/10/24.
 */
public abstract class Sender {

    private static TaskExecutor executor;

    static {
        ThreadConfig threadConfig=new ThreadConfig();
        threadConfig.setName("-data-exchange-channel-thread-");
        threadConfig.setMaxCount(Config.threadConfig().getMaxCount());
        threadConfig.setAliveCount(Config.threadConfig().getAliveCount());
        threadConfig.setAliveTime(Config.threadConfig().getAliveTime());
        SimpleThreadPoolExecutorFactory simpleThreadPoolExecutorFactory=
                new SimpleThreadPoolExecutorFactory(threadConfig);
        executor=new TaskExecutor(simpleThreadPoolExecutorFactory);
    }

    public static void send(HeartbeatRequest request){

        executor.promise(new Task() {
            @Override
            public void run() {
                new HeartbeatCommand().execute(request, Handler::noop);
            }
        });


    }


    public static void send(DataRequest request) {
        executor.promise(new Task() {
            @Override
            public void run() {
                new DataCommand().execute(request, Handler::noop);
            }

        });

    }

}
