package cn.good.mybatis.mapping;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/4/30
 **/
public interface SqlSource {
    BoundSql getBoundSql(Object parameterObject);
}
