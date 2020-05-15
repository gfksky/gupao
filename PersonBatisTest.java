package com.personbatis.mapper;

public class PersonBatisTest {
    public static void main(String[] args) {
        PsSqlSession sqlSession = new PsSqlSession(new PsConfiguration(), new PsExecutor());
        AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
        authorMapper.selectAuthorById(1);
    }
}
