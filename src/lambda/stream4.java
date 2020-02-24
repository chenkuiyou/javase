package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author cky
 * @create 2020 2 23 19:53
 */
public class stream4 {
    public static void main(String[] args) {

        //
        List<Integer> l= new ArrayList<>();
        l.add(1);
        l.add(99);
        l.add(100);
        l.add(1333);
        l.add(1456);
        l.add(1456);
        l.add(1333);
        int sum=l.stream().reduce(0,Integer::sum);
        System.out.println(sum);
//        reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一
//        个值。返回 Optional<T>
        Optional<Integer> sum1=l.stream().reduce((a, b)->a+b);
        System.out.println(sum1);

//        collect(Collector c)将流转换为其他形式。
//        接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
//        其实就是将流的操作结果转换为 collection
//        需要调用 Collector中的方法将其转换为 需要的collection 类型
        List<Integer> collect = l.stream().filter((i) -> i > 50).collect(Collectors.toList());
        System.out.println(collect);
    }
}
