package com.am.spring.itheima.jdbc;

import java.sql.*;

/**
 * @author Love
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        // 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_itheima?serverTimezone=UTC", "root", "root");
        // 获取操作数据库的预处理对象
        PreparedStatement statement = connection.prepareStatement("select * from account");
        // 执行SQL，得到结果集
        ResultSet resultSet = statement.executeQuery();
        // 遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        // 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
