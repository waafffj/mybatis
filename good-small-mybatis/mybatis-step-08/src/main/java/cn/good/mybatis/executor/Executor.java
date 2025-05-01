package cn.good.mybatis.executor;

import cn.good.mybatis.mapping.BoundSql;
import cn.good.mybatis.mapping.MappedStatement;
import cn.good.mybatis.session.ResultHandler;
import cn.good.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * TODO
 *
 * @Description 执行器
 * @Author wkm
 * @Date 2025/1/2
 **/
public interface Executor {
    ResultHandler NO_RESULT_HANDLER = null;
    <E>List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);
    Transaction getTransaction();
    void commit(boolean required) throws SQLException;
    void rollback(boolean required) throws SQLException;
    void close(boolean forceRollback);
}
