package cn.good.mybatis.scripting.xmltags;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/5/1
 **/
public interface SqlNode {
    boolean apply(DynamicContext context);
}
