package cn.good.mybatis.reflection.property;

import java.util.Iterator;

/**
 * TODO
 *
 * @Description 属性分解标记
 * @Author wkm
 * @Date 2025/1/5
 **/
public class PropertyTokenizer implements Iterable<PropertyTokenizer>, Iterator<PropertyTokenizer> {
    /* 例子: 班级[0].学生.成绩 */
    /* 班级*/
    private String name;
    /* 班级[0] */
    private String indexedName;
    /* 0 */
    private String index;
    /* 学生.成绩 */
    private String children;


    public String getName() {
        return name;
    }

    public String getIndex() {
        return index;
    }

    public String getIndexedName() {
        return indexedName;
    }

    public String getChildren() {
        return children;
    }


    @Override
    public boolean hasNext() {
        return children != null;
    }

    public PropertyTokenizer(String fullname){
        int delim = fullname.indexOf('.');
        if(delim > -1){
            name = fullname.substring(0,delim);
            children = fullname.substring(delim + 1);
        }else {
            /* 找不到.的话，取全部部分 */
            name = fullname;
            children = null;
        }
        indexedName = name;
        /* 把中括号的数字给解析出来*/
        delim = name.indexOf('[');
        if(delim > -1){
            index = name.substring(delim + 1,name.length() -1);
            name = name.substring(0,delim);
        }
    }
    @Override
    public PropertyTokenizer next() {
        return new PropertyTokenizer(children);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove is not supported, as it has no meaning in the context of properties.");
    }

    @Override
    public Iterator<PropertyTokenizer> iterator() {
        return this;
    }
}
