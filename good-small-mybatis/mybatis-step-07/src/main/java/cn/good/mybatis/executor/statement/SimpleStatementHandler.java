package cn.good.mybatis.executor.statement;

import cn.good.mybatis.executor.Executor;
import cn.good.mybatis.executor.resultset.ResultSetHandler;
import cn.good.mybatis.mapping.BoundSql;
import cn.good.mybatis.mapping.MappedStatement;
import cn.good.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @Description 简单语句处理器
 * @Author wkm
 * @Date 2025/1/2
 **/
public class SimpleStatementHandler extends BaseStatementHandler{
    protected SimpleStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultHandler resultSetHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, resultSetHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {

    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        String sql = boundSql.getSql();
        statement.execute(sql);
        return resultSetHandler.handleResultSets(statement);
    }
}
