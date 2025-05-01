package cn.good.mybatis.mapping;

import cn.good.mybatis.session.Configuration;
import cn.good.mybatis.type.JdbcType;

/**
 * TODO
 *
 * @Description 参数映射 #{property,javaType=int,jdbcType=NUMERIC}
 * @Author wkm
 * @Date 2024/12/21
 **/
public class ParameterMapping {
    private Configuration configuration;
    private String property;
    private Class<?> javaType = Object.class;
    private JdbcType jdbcType;

    private ParameterMapping() {
    }

    public static class Builder {

        private ParameterMapping parameterMapping = new ParameterMapping();

        public Builder(Configuration configuration, String property) {
            parameterMapping.configuration = configuration;
            parameterMapping.property = property;
        }

        public Builder javaType(Class<?> javaType) {
            parameterMapping.javaType = javaType;
            return this;
        }

        public Builder jdbcType(JdbcType jdbcType) {
            parameterMapping.jdbcType = jdbcType;
            return this;
        }

    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public String getProperty() {
        return property;
    }

    public Class<?> getJavaType() {
        return javaType;
    }

    public JdbcType getJdbcType() {
        return jdbcType;
    }

}
