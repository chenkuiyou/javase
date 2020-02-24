package Annotation;

/**
 *
 *
 * 定义新的 Annotation 类型使用 @interface 关键字
 * 1.自定义注解自动继承了java.lang.annotation.Annotaton接口i
 * Annotation 的成员变量在 Annotation 定义中以无参数方法的形式来声明。其
 * 方法名和返回值定义了该成员的名字和类型。我们称为配置参数。类型只能
 * 是八种基本数据类型、String类型、Class类型、enum类型、Annotation类型、以上所有类型的数组。
 *
 *
 * @author cky
 * @create 2020 2 17 11:16
 */
public @interface MyAnnotation {
    //使用default给注解赋默认值
    String values()  default "hello";

}
