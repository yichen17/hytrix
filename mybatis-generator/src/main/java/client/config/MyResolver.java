package client.config;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * @author Qiuxinchao
 * @version 1.0
 * @date 2021/11/9 10:07
 * @describe  解决 tinyint 转换为 byte 的问题
 */
public class MyResolver extends JavaTypeResolverDefaultImpl {
    public MyResolver(){
        super();
        typeMap.put(-6, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName()))); // 当类型为TINYINT时，则生成的Java类型为Integer
    }
}
