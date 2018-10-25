package me.libme.module.exchange.client;

import me.libme.kernel._c.util.JStringUtils;

/**
 * Created by J on 2018/10/24.
 */
public class Request {

    private String ak;

    private String dataSourceName;

//    private String dataSourceCode;


    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

//    public String getDataSourceCode() {
//        return dataSourceCode;
//    }
//
//    public void setDataSourceCode(String dataSourceCode) {
//        this.dataSourceCode = dataSourceCode;
//    }


    public void initClient(Config.Client client){
        if(JStringUtils.isNullOrEmpty(ak)){
            this.ak=client.getAk();
        }
        if(JStringUtils.isNullOrEmpty(dataSourceName)){
            this.dataSourceName=client.getSourceName();
        }

    }


}
