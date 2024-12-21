package cn.good.mybatis.transaction.jdbc;

import cn.good.mybatis.session.TransactionIsolationLevel;
import cn.good.mybatis.transaction.Transaction;
import cn.good.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * TODO
 *
 * @Description JdbcTransaction 工厂
 * @Author wkm
 * @Date 2024/12/21
 **/
public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return newTransaction(dataSource,level,autoCommit);
    }
}
