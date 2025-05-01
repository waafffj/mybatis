package cn.good.mybatis.session.defaults;

import cn.good.mybatis.executor.Executor;
import cn.good.mybatis.mapping.Environment;
import cn.good.mybatis.session.Configuration;
import cn.good.mybatis.session.SqlSession;
import cn.good.mybatis.session.SqlSessionFactory;
import cn.good.mybatis.session.TransactionIsolationLevel;
import cn.good.mybatis.transaction.Transaction;
import cn.good.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * TODO
 *
 * @Description 默认的DefaultSqlSessionFactory
 * @Author wkm
 * @Date 2024/12/17
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try{
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED,false);
            /* 创建执行器*/
            final Executor executor = configuration.newExecutor(tx);
            /* 创建DefaultSqlSession*/
            return new DefaultSqlSession(configuration,executor);
        }catch (Exception e){
            try {
                assert tx != null;
                tx.close();
            }catch (SQLException ignore){

            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }
}
