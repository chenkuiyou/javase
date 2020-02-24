package Annotation;

import java.util.ArrayList;

/**
 *
 * annotation 注解
 * jdk5.0新增属性
 * java 原有的三个注解
 *      Override  （只用于方法重写的时候）
 *      Deprecated (修饰构造器，表示方法已经过时，不代表构造器不能使用)
 *      SuppressWarnings  （抑制编译器警告 ）  例如定义变量没有使用
 *
 * 自定义注解（略）
 *
 * jdk中的4个元注解
 * Retention   指定所修饰的annotation的生命周期 内部有一个enum类有三个成员
 *              SOURCE   不会被编译
 *              CLASS    默认值  会进入编译，不进入内存
 *              RUNTIME  会进到内存中
 *
 * Target       表示  所修饰的annotation  能修饰哪些结构
 *                 TYPE, FIELD, METHOD等等
 *                 表明这个注解可以修饰 类型，域 方法，等等
 * Documented   少用
 * Inherited    少用 表示所修饰的注解A  去修饰某个类的时候，这个类的子类也带有注解A
 *
 *在jdk1.8之后添加了 可重复注解和类型注解
 *
 * @author cky
 * @create 2020 2 17 11:00
 */
public class text {
    public static void main(String[] args) {

        @SuppressWarnings("unused")
        int n=10;
        @SuppressWarnings({"unused","rawtypes"})
        //        rawtypes是抑制泛型的警告
        ArrayList list=new ArrayList();
    }
}
