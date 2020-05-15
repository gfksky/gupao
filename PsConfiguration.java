package com.personbatis.mapper;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class PsConfiguration {
    public static final ResourceBundle sqlMappings;
    static {
        sqlMappings = ResourceBundle.getBundle("sql");
    }
    public <T> T getMapper(Class clazz,PsSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new PsMapperProxy(sqlSession));
    }
}
