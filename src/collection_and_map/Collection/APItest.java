package collection_and_map.Collection;

import java.util.*;

/**
 * collection中的几个API
 * 在使用collection的api的时候一般都要重写equals方法，大部分方法都会调用
 * @author cky
 * @create 2020 2 17 12:11
 */
public class APItest {
    public static void main(String[] args) {
        Collection c=new ArrayList();

        //add()往集合c中添加对象
        c.add("aa");
        c.add("123");
        c.add(123);
        c.add(new Date());

        //size()获取集合的大小
        System.out.println(c.size());

        //addALL(Collection c) 将另外一个集合的元素加到这个集合中

        c.addAll(c);

        //isEmpty() 判断集合是否为空

        System.out.println(c.isEmpty());

        //clear()  清空集合

        //c.clear();
        //System.out.println(c.isEmpty());

        //contain（Object ojb）判断集合c中有没有包含obj
        //在判断是否相等的时候，调用的是equals方法 如果类中没有重写equals方法 调用父类的
        //Ojbect中的equals就是==判断
        c.contains(123);

        //containALL（Collection c）判断集合中有没有包含集合c的全部元素
        System.out.println(c.containsAll(c));

        //remove 在remove中也有调用equals方法 有放回值，有且删除成功为true,并且只删除一个

        System.out.println(c);
        System.out.println("!!!"+c.remove(123));
        System.out.println(c);

        //removeALL（Collection c）移除集合中c中的全部元素
        //c.removeAll(c);  //相当于求集合的差集
        //System.out.println(c.isEmpty());

        //retainAll（Collection c）  求两个集合的交集
        // 并且将结果给原来的集合
        c.retainAll(c);

        //equals(Objec ojb)  //如果有序会比较顺序
        //c.equals(c);

        //hashCode()  //返回对象的哈希值
        c.hashCode();

        //toArray()  集合到数组的转换
        Object []obj=c.toArray();
        for(Object o:obj){
            System.out.println(o);
        }
        //数组变为集合
        System.out.println(Arrays.asList(obj).getClass());

        //迭代器   iterator  这边 iterator 获取的c.iterator()  之后 iterator 不会影响c.iterator()
        //c.iterator()永远都是指向第一个元素的前面
        Iterator iterator=c.iterator();

        //iterator.next()  获取迭代器中的下一个元素
        System.out.println(iterator.next());

        //遍历集合的元素
        //刚刚开始的时候迭代器的指针指向空 （第一个元素的前面）
        //调用iterator.hasNext() 就是判断指针的下个位置有没有东西 有true 无false
        //调用iterator.next() 就是将指针移动到下个位置，并且返回下个位置的值
        //如果下个位置没有值了 会产生报错NoSuchElementException
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //System.out.println(iterator.next());


        //iterator.remove()
        //会报错的两种情况
        //1。没有调用 iterator.next()  就调用 remove
        //2.在调用过iterator.next() 调用两次iterator.remove()
        //就是在调用过iterator.remove() 后，只能调用一次或者0次 remove

        while (iterator.hasNext()) {
            Object o=iterator.next();
//             if(o.equals(***)){
//                iterator.remove();
//             }
        }

        //增强for循环  for(Object  o: Collection/数组) {***}
        //本质上用的还是迭代器
        System.out.println("************");
        for(Object o:c){
            System.out.println(o);
        }
        //但是如果想更改o中的变量，不能使用增强for循环
        //增强for循环只是将iterator中的值取出赋值给i
        Collection<Integer> t=new ArrayList<Integer>();
        t.add(1);
        t.add(2);
        t.add(3);
        for (Integer i:t){
            System.out.println(i); //输出 1 2 3
            i=0;
        }
        for (Integer i:t){
            System.out.println(i);//输出 1 2 3
        }
    }
}
