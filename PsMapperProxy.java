package com.personbatis.mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PsMapperProxy implements InvocationHandler {
    private PsSqlSession sqlSession;

    public PsMapperProxy(PsSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterface = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterface+"."+methodName;
        return sqlSession.selectOne(statementId,args[0]);
    }
}
