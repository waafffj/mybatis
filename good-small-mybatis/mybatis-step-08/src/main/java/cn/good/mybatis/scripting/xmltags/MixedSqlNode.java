package cn.good.mybatis.scripting.xmltags;

import java.util.List;

/**
 * TODO
 *
 * @Description 混合SQL节点
 * @Author wkm
 * @Date 2025/5/1
 **/
public class MixedSqlNode implements SqlNode{
// 组合模式,拥有一个SqlNode的List   存储所有子节点的集合
 private List<SqlNode> contents;

 public MixedSqlNode(List<SqlNode> contents) {
  this.contents = contents;
 }

 @Override
 public boolean apply(DynamicContext context) {
  // 依次调用list中每个元素的apply
  contents.forEach(node -> node.apply(context));
  return true;
 }
}
