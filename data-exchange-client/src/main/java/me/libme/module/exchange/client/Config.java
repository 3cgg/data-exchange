package me.libme.module.exchange.client;

import me.libme.kernel._c.async.ThreadConfig;
import me.libme.kernel._c.yaml.YamlMapConfig;

import java.io.InputStream;

/**
 * Created by J on 2018/10/24.
 */
public abstract class Config {


    private static ThreadConfig threadConfig=new ThreadConfig();

    private static Server server=new Server();

    private static Client client=new Client();

    static {

        try(InputStream inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream("data-exchange-client.yml")){
            YamlMapConfig yamlMapConfig=new YamlMapConfig(inputStream);
            threadConfig.setMaxCount(yamlMapConfig.getInt("thread.maxCount",10));
            threadConfig.setAliveCount(yamlMapConfig.getInt("thread.aliveCount",5));
            threadConfig.setAliveTime(yamlMapConfig.getInt("thread.aliveTime",60));

            server.setHost(yamlMapConfig.getString("server.host","http://localhost:8585"));
            server.setPrefix(yamlMapConfig.getString("server.prefix","/scc/exchange/httpApi"));

            client.setAk(yamlMapConfig.getString("client.ak","AK"));
            client.setSourceName(yamlMapConfig.getString("client.name","Source Name"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static Server server(){
        return server;
    }


    public static ThreadConfig threadConfig(){
        return threadConfig;
    }

    public static Client client(){return client;}


    public static class Client {

        private String ak;

        private String sourceName;

        private String node;


        public String getAk() {
            return ak;
        }

        public void setAk(String ak) {
            this.ak = ak;
        }

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public String getNode() {
            return node;
        }

        public void setNode(String node) {
            this.node = node;
        }
    }



}
