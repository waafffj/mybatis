package cn.good.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * TODO
 *
 * @Description 类型处理器
 * @Author wkm
 * @Date 2025/4/30
 **/
public interface TypeHandler<T> {
    /**
     *
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    void setParameter(PreparedStatement ps,int i,T parameter,JdbcType jdbcType) throws SQLException;
}
