package cn.good.mybatis.datasource.pooled;

import cn.good.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * TODO
 *
 * @Description 有连接池的数据源工厂
 * @Author wkm
 * @Date 2025/1/1
 **/
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {
    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }
}
