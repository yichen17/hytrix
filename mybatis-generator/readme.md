## entity实体中不加 example
```
// <table 中属性添加如下内容  />
enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"
```

## 数据库 tinyint 被转译成 byte
```
// 定义一个 类型转换规则
public class MyResolver extends JavaTypeResolverDefaultImpl {
    public MyResolver(){
        super();
        typeMap.put(-6, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName()))); // 当类型为TINYINT时，则生成的Java类型为Integer
    }
}
//  这里type 引入上面定义的 类的全路径
<javaTypeResolver type="client.config.MyResolver">
    <!--
    true：使用BigDecimal对应DECIMAL和 NUMERIC数据类型
    false：默认,
       scale>0;length>18：使用BigDecimal;
       scale=0;length[10,18]：使用Long；
       scale=0;length[5,9]：使用Integer；
       scale=0;length<5：使用Short；
     -->
    <property name="forceBigDecimals" value="true"/>
</javaTypeResolver>
```

## generatorConfig 说明
+ generatorConfig-manage 和 jeesite 清结算对账 生成工具
+ generatorConfig-normal 常用类型
+ generatorConfig 现用版本
+ generatorConfig-perfect 优化版本

## perfect 记录
通过 idea 执行运行 mvn,提示 The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
但是直接通过 mvn mybatis-generator:generate 却可以