package com.personbatis.mapper;

import java.sql.*;

public class PsExecutor {
    public <T> T query(String sql, Object paramater) {
        Connection conn = null;
        Statement stmt = null;
        Author author = new Author();

        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "123456");

            // 执行查询
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format(sql, paramater));

            // 获取结果集
            while (rs.next()) {
                Integer authorId = rs.getInt("authorid");
                String authorName = rs.getString("authorName");
                author.setAuthorId(authorId);
                author.setAuthorName(authorName);

            }
            System.out.println(author);

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T) author;
    }
}
