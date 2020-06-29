package com.kiteYY.mybatis.cfg;


/**
 * 用于封装执行Sql语句和结果的类型的全限定语句
 */
public class Mapper {

    public String getQueryString() {
        return queryString;
    }

    public String getResultType() {
        return resultType;
    }

    private String queryString;  //SQL语句
    private String resultType;//实体类的全限定类名

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
