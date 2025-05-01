package cn.good.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * TODO
 *
 * @Description 结果集处理器
 * @Author wkm
 * @Date 2025/1/2
 **/
public interface ResultSetHandler {
    <E>List<E> handleResultSets(Statement stmt) throws SQLException;
}
