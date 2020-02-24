package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author cky
 * @create 2020 2 23 19:35
 */
public class stream3 {
    public static void main(String[] args) {
        List<person> l= new ArrayList<>();
        l.add(new person("cky",220));
        l.add(new person("ffq",223));
        l.add(new person("xgy",221));
        l.add(new person("lhr",219));
        l.add(new person("zzw",218));
//        allMatch(Predicate p) 检查是否匹配所有元素  返回boolean
        System.out.println(l.stream().allMatch(person -> person.id >220));
//        anyMatch(Predicate p) 检查是否至少匹配一个元素  返回boolean
        System.out.println(l.stream().anyMatch(person -> person.id == 222));
//        noneMatch(Predicate p) 返回是否没有匹配的元素   集合中都没有匹配的元素返回true 和anyMatch相反
        System.out.println(l.stream().noneMatch(person -> person.id== 222));
//        findFirst() 返回第一个元素  返回的类型是Optional
        System.out.println(l.stream().findFirst());
//        findAny() 返回当前流中的任意元素   返回的是固定的, 并行流野返回同一个
        System.out.println(l.stream().findAny());
//        count() 返回流中元素总数
        System.out.println(l.stream().count()) ;
//        max(Comparator c) 返回流中最大值    Optional返回值
        System.out.println(l.stream().max(person::compareTo));
//        min(Comparator c) 返回流中最小值

        System.out.println(l.stream().min(person::compareTo));

//        forEach(Consumer c)
//        内部迭代(使用 Collection 接口需要用户去做迭代，
//                称为外部迭代。相反，Stream API 使用内部迭
//                代——它帮你把迭代做了)
    }
}
