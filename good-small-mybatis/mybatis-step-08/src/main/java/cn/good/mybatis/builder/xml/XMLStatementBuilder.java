package cn.good.mybatis.builder.xml;

import cn.good.mybatis.builder.BaseBuilder;
import cn.good.mybatis.mapping.MappedStatement;
import cn.good.mybatis.mapping.SqlCommandType;
import cn.good.mybatis.mapping.SqlSource;
import cn.good.mybatis.scripting.LanguageDriver;
import cn.good.mybatis.session.Configuration;
import org.dom4j.Element;

import java.util.Locale;

/**
 * TODO
 *
 * @Description XML语句构建器
 * @Author wkm
 * @Date 2025/5/1
 **/
public class XMLStatementBuilder extends BaseBuilder {
    private String currentNamespace;
    /* Element 接口是框架内部用于处理 XML 映射文件中的标签元素的核心抽象  */
    private Element element;

    public XMLStatementBuilder(Configuration configuration, Element element, String currentNamespace) {
        super(configuration);
        this.element = element;
        this.currentNamespace = currentNamespace;
    }

    //解析语句(select|insert|update|delete)
    //<select
    //  id="selectPerson"
    //  parameterType="int"
    //  parameterMap="deprecated"
    //  resultType="hashmap"
    //  resultMap="personResultMap"
    //  flushCache="false"
    //  useCache="true"
    //  timeout="10000"
    //  fetchSize="256"
    //  statementType="PREPARED"
    //  resultSetType="FORWARD_ONLY">
    //  SELECT * FROM PERSON WHERE ID = #{id}
    //</select>
    public void parseStatementNode(){
        String id = element.attributeValue("id");
        // 参数类型
        String parameterType = element.attributeValue("parameterType");
        Class<?> parameterTypeClass = resolveAlias(parameterType);
        // 结果类型
        String resultType = element.attributeValue("resultType");
        Class<?> resultTypeClass = resolveAlias(resultType);
        // 获取命令类型(select|insert|update|delete)
        String nodeName = element.getName();
        SqlCommandType sqlCommandType = SqlCommandType.valueOf(nodeName.toUpperCase(Locale.ENGLISH));

        // 获取默认语言驱动器
        Class<?> langClass = configuration.getLanguageRegistry().getDefaultDriverClass();
        LanguageDriver languageDriver = configuration.getLanguageRegistry().getDriver(langClass);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration,element,parameterTypeClass);
        MappedStatement mappedStatement = new MappedStatement.Builder(configuration,currentNamespace + "." + id,sqlCommandType,sqlSource,resultTypeClass).build();
        // 添加解析SQL
        configuration.addMappedStatement(mappedStatement);
    }
}
