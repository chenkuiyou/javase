package lambda;

import java.io.PrintStream;

/**
 * 方法引用
 *    能组合的三种方式
 *     对象：：非静态方法
 *     类：：非静态方法
 *     类：：静态方法
 *
 * 感觉方法引用太花里胡哨了， 比起lambda 来说，代码可读性太差
 * @author cky
 * @create 2020 2 23 15:02
 */
public class method_references {
    public static void main(String[] args) {

//      用lambda表达式写是
        T t=  (s)->{System.out.println(s);};
        t.show("hello");

        //调用 对象的非静态方法
        //这里相当于调用了 out对象的println方法 因为方法需要的参数和返回值类型相同，所以能够使用
        PrintStream p= System.out;
        T t1=p::println;
        t.show("world");


        //调用 类的静态方法
        M<Integer> t2=Integer::compare;
        System.out.println(t2.compare(2, 2));


    }
}
interface  T<T>{
    void show(String s);

}
interface  M<T>{
    int compare(T t1, T t2);
}
