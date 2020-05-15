package com.personbatis.mapper;

public class PsSqlSession {
    //对外提供的API的2个属性
    PsConfiguration configuration;
    PsExecutor executor;    //执行器

    public PsSqlSession(PsConfiguration configuration, PsExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    //查询数据的方法
    public <T> T selectOne(String statementId,Object paramater){
        String sql = configuration.sqlMappings.getString(statementId);
        return executor.query(sql,paramater);
    }
    public <T>T getMapper(Class clazz){
        return configuration.getMapper(clazz,this);
    }
}
