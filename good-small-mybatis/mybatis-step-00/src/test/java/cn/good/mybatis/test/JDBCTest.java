package cn.good.mybatis.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2024/12/14
 **/
public class JDBCTest {
    @Test
    public void test_jdbc() throws Exception {
        /* 加载驱动*/
        Class.forName("com.mysql.jdbc.Driver");

        /* 连接信息*/
        String url = "jdbc:mysql://127.0.0.1:3306/mybatis?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "wkm20031105";
        /* 连接成功 */
        Connection connection = DriverManager.getConnection(url,username,password);

        /* 执行SQL的对象获取 */
        Statement statement = connection.createStatement();
        /* 待执行SQL */
        String sql = "SELECT id,userId,userName,userHead FROM user";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.print("id=" + resultSet.getObject("id") + " ");
            System.out.print("userId=" + resultSet.getObject("userId") + " ");
            System.out.print("userName=" + resultSet.getObject("userName") + " ");
            System.out.print("userHead=" + resultSet.getObject("userHead"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
