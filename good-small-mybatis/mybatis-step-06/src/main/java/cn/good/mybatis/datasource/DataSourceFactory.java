package cn.good.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * TODO
 *
 * @Description 数据源工厂
 * @Author wkm
 * @Date 2024/12/21
 **/
public interface DataSourceFactory {
    void setProperties(Properties props);
    DataSource getDataSource();
}
