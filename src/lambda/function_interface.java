package lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 函数式接口和lanbda表达式 是两个不同的技术， lambda可以化简 函数式接口的编写方法
 * java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 *
 * @author cky
 * @create 2020 2 22 16:15
 */
public class function_interface {

    public static void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    public static void main(String[] args) {

// * 消费型接口 Consumer<T>     void accept(T t)
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("瓶矿泉水，价格为：" + aDouble);
            }
        });

        System.out.println("********************");

        happyTime(400,money -> System.out.println("喝了口水，价格为：" + money));

// * 供给型接口 Supplier<T>     T get()
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);
        List<String> filterStrs1 = filterString(list,s -> s.contains("京"));
        System.out.println(filterStrs1);

    }
    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public static List<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> filterList = new ArrayList<>();

        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}


