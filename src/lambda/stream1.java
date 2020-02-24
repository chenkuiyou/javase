package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * Stream
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 * @author cky
 * @create 2020 2 23 17:03
 */
public class stream1 {
    public static void main(String[] args) {
        List<Integer> l= new ArrayList<>();
        l.add(1);
        l.add(99);
        l.add(100);
        l.add(1333);
        l.add(1456);
        l.add(1456);
        l.add(1333);
        //创建流
        Stream<Integer> stream=l.stream();
//        filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
//        相当于是对 stream中的元素进行过滤操作，让后将过滤出来的元素进行 forEach中内容的操作
        stream.filter( i-> i>100).forEach(System.out::println);

//        limit(long maxSize) 截断流，使其元素不超过给定数量
        System.out.println("--------");
        l.stream().limit(2).forEach(System.out::println);

//        skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一
//        个空流。与 limit(n) 互补
        System.out.println("--------");
        l.stream().skip(3).forEach(System.out::println);
//        distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        System.out.println("--------");
        l.stream().distinct().forEach(System.out::println);
    }
}
