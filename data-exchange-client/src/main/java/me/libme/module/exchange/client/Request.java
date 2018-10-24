package me.libme.module.exchange.client;

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

}
