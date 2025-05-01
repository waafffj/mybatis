package cn.good.mybatis.executor.statement;

import cn.good.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * TODO
 *
 * @Description 语句处理器
 * @Author wkm
 * @Date 2025/1/2
 **/
public interface StatementHandler {
    /* 准备语句 */
    Statement prepare(Connection connection) throws SQLException;
    /* 参数化 */
    void parameterize(Statement statement) throws SQLException;
    /* 执行查询 */
    <E>List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;
}
