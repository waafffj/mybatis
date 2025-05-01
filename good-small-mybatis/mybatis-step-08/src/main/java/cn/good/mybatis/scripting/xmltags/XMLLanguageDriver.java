package cn.good.mybatis.scripting.xmltags;

import cn.good.mybatis.mapping.SqlSource;
import cn.good.mybatis.scripting.LanguageDriver;
import cn.good.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * TODO
 *
 * @Description XML语言驱动器
 * @Author wkm
 * @Date 2025/5/1
 **/
public class XMLLanguageDriver implements LanguageDriver {
    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration,script,parameterType);
        return builder.parseScriptNode();
    }
}
