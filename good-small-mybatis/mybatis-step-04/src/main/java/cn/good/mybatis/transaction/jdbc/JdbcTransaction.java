package cn.good.mybatis.transaction.jdbc;

import cn.good.mybatis.session.TransactionIsolationLevel;
import cn.good.mybatis.transaction.Transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * TODO
 *
 * @Description JDBC 事务 直接利用JDBC的 commit、rollback、依赖于数据源获得的连接来管理事务范围
 * @Author wkm
 * @Date 2024/12/21
 **/
public class JdbcTransaction implements Transaction {
    protected Connection connection;

    public JdbcTransaction(Connection connection) {
        this.connection = connection;
    }

    protected DataSource dataSource;
    protected TransactionIsolationLevel level = TransactionIsolationLevel.NONE;
    protected boolean autoCommit;

    public JdbcTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        this.dataSource = dataSource;
        this.level = level;
        this.autoCommit = autoCommit;
    }

    @Override
    public Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        connection.setTransactionIsolation(level.getLevel());
        connection.setAutoCommit(autoCommit);
        return connection;
    }

    @Override
    public void commit() throws SQLException {
        if(connection != null && !connection.getAutoCommit()){
            connection.commit();
        }
    }

    @Override
    public void rollback() throws SQLException {
        if(connection != null && !connection.getAutoCommit()){
            connection.rollback();
        }
    }

    @Override
    public void close() throws SQLException {
        if(connection != null && !connection.getAutoCommit()){
            connection.close();
        }
    }
}
