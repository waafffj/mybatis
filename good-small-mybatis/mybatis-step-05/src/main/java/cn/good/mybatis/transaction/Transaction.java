package cn.good.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * TODO
 *
 * @Description 事务接口
 * @Author wkm
 * @Date 2024/12/21
 **/
public interface Transaction {
    Connection getConnection()throws SQLException;
    void commit()throws SQLException;
    void rollback()throws SQLException;
    void close()throws SQLException;
}
