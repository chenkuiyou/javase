package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream中的映射方法
 *       map(Function f)
 *       flatMap(Function f)
 * Stream中的排序方法
 *      sorted() 产生一个新流，其中按自然顺序排序
 *      sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
 * @author cky
 * @create 2020 2 23 17:20
 */
public class stream2 {
    public static void main(String[] args) {
        List<person> l= new ArrayList<>();
        l.add(new person("cky",220));
        l.add(new person("ffq",223));
        l.add(new person("xgy",221));
        l.add(new person("lhr",219));
        l.add(new person("zzw",218));
//        map(Function f)  接收一个函数作为参数，该函数会被应
//        用到每个元素上，并将其映射成一个新的元素。
        //提供了一个map 映射函数 给一个person 对象返回他的类
        //这边可以看到返回的是流
        Stream<String> stringStream = l.stream().map(person -> person.getName()+"hello");
        stringStream.forEach(System.out::println);

//        flatMap(Function f) 接收一个函数作为参数，这个函数必须返回 一个Stream
//        对于map来说 这些返回的Strean 会被当作一个元素放在一个Stream中 相当于是 Stream<Stream<T>>
//        如果使用flatMap 那么会将所有返回的Stream 进行组装连接，最后的类型是Stream<T>
        l.stream().flatMap(person -> f(person) ).forEach(System.out::println);

//        sorted() 产生一个新流，其中按自然顺序排序

//        sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        l.stream().sorted((p1,p2)-> Integer.compare(p1.id,p2.id)).forEach(System.out::println);
//        如果不使用定制排序，那么必须实现comparable接口重新 compareTo



    }
    public static  Stream<Character>  f(person arg){
        ArrayList<Character> res=new ArrayList<>();
        for(char c:arg.getName().toCharArray()){
            res.add(c);
        }
        return  res.stream();
    }
}
class person  implements Comparable{
    String name;
    int id;
    person(){}
    public person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof  person){
            person p=(person)o;
            return Integer.compare(id,p.id);
        }
        return 0;
    }
}
