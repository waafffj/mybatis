package cn.good.mybatis.builder;

import cn.good.mybatis.session.Configuration;
import cn.good.mybatis.type.TypeAliasRegistry;
import cn.good.mybatis.type.TypeHandlerRegistry;

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
    protected final TypeHandlerRegistry typeHandlerRegistry;

    protected BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
        this.typeHandlerRegistry = this.configuration.getTypeHandlerRegistry();
    }
    public Configuration getConfiguration(){
        return configuration;
    }
    protected  Class<?> resolveAlias(String alias){
        return typeAliasRegistry.resolveAlias(alias);
    }
}
