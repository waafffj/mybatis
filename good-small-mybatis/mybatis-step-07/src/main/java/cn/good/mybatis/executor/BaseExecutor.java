package cn.good.mybatis.executor;

import cn.good.mybatis.mapping.BoundSql;
import cn.good.mybatis.mapping.MappedStatement;
import cn.good.mybatis.session.Configuration;
import cn.good.mybatis.session.ResultHandler;
import cn.good.mybatis.transaction.Transaction;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * TODO
 *
 * @Description 执行器抽象基类
 * @Author wkm
 * @Date 2025/1/2
 **/
public abstract class BaseExecutor implements Executor{

    private org.slf4j.Logger logger = LoggerFactory.getLogger(BaseExecutor.class);
    protected Configuration configuration;
    protected Transaction transaction;
    protected Executor wrapper;
    private boolean closed;

    protected BaseExecutor(Configuration configuration,Transaction transaction){
        this.configuration = configuration;
        this.transaction = transaction;
        this.wrapper = this;
    }
    @Override
    public <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        if(closed){
            throw new RuntimeException("Executor was closed.");
        }
        return doQuery(ms,parameter,resultHandler,boundSql);
    }

    protected abstract <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);

    @Override
    public Transaction getTransaction() {
        if(closed){
            throw new RuntimeException("Executor was closed.");
        }
        return transaction;
    }

    @Override
    public void commit(boolean required) throws SQLException {
        if(closed){
            throw new RuntimeException("Executor was closed.");
        }
        if(required){
            transaction.commit();
        }
    }

    @Override
    public void rollback(boolean required) throws SQLException {
        if(!closed){
            if(required){
                transaction.rollback();
            }
        }
    }

    @Override
    public void close(boolean forceRollback) {
        try{
            try{
                rollback(forceRollback);
            }finally {
                transaction.close();
            }
        }catch (SQLException e){
            logger.warn("Unexpected exception on closing transaction.  Cause: " + e);
        }finally {
            transaction = null;
            closed = true;
        }
    }
}
