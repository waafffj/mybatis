package cn.good.mybatis.scripting;

import cn.good.mybatis.mapping.SqlSource;
import cn.good.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * TODO
 *
 * @Description 脚本语言驱动
 * @Author wkm
 * @Date 2025/4/30
 **/
public interface LanguageDriver {
    SqlSource createSqlSource(Configuration configuration, Element script,Class<?> parameterType);
}
