package cn.good.mybatis.executor;

import cn.good.mybatis.executor.statement.StatementHandler;
import cn.good.mybatis.mapping.BoundSql;
import cn.good.mybatis.mapping.MappedStatement;
import cn.good.mybatis.session.Configuration;
import cn.good.mybatis.session.ResultHandler;
import cn.good.mybatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * TODO
 *
 * @Description 简单执行器
 * @Author wkm
 * @Date 2025/1/2
 **/
public class SimpleExecutor extends BaseExecutor{

    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        try{
            Configuration configuration = ms.getConfiguration();
            StatementHandler handler = configuration.newStatementHandler(this,ms,parameter,resultHandler,boundSql);
            Connection connection = transaction.getConnection();
            Statement stmt = handler.prepare(connection);
            handler.parameterize(stmt);
            return handler.query(stmt,resultHandler);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
