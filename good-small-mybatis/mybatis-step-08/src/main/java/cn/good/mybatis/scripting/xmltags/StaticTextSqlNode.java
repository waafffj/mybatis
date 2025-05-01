package cn.good.mybatis.scripting.xmltags;

/**
 * TODO
 *
 * @Description 静态文本SQL节点
 * @Author wkm
 * @Date 2025/5/1
 **/
public class StaticTextSqlNode implements SqlNode{
    private String text;

    public StaticTextSqlNode(String text) {
        this.text = text;
    }

    @Override
    public boolean apply(DynamicContext context) {
        // jiangwen
        context.appendSql(text);
        return true;
    }
}
