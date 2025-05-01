package cn.good.mybatis.builder;

import cn.good.mybatis.session.Configuration;
import cn.good.mybatis.type.TypeAliasRegistry;

/**
 * TODO
 *
 * @Description 构建器的基类，建造者模式
 * @Author wkm
 * @Date 2024/12/20
 **/
public abstract class BaseBuilder {
    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    protected BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }
    public Configuration getConfiguration(){
        return configuration;
    }
}
