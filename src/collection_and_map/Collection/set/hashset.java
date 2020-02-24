package collection_and_map.Collection.set;

import java.util.HashSet;

/**
 *
 *     hashset底层是用 数组+链表实现的  邻接表
 *
 *
 * @author cky
 * @create 2020 2 17 12:07
 */
public class hashset {

    public static void main(String[] args){
        /// hashset 经典面试题
        //hashset 只有在需要 查找（例如查找，插入，删除的时候 会使用hashcode(）
        //在修改对象的时候不会使用hashcode 尽管对象被修改之后不应该放在原本的位置了
        HashSet set = new HashSet();

        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.name = "BB";

        set.remove(p1);
        System.out.println(set);


        //通过使用System.identityHashCode(Object) 获得这个对象的内存地址
        //这说明 hashset中是通过存对象在 堆中的地址，来存对象的
        System.out.println("*********");
        for (Object i : set) {
            if(System.identityHashCode(i)==System.identityHashCode(p1)){
                System.out.println(i);
            }

        }
        System.out.println("*********");


        set.add(new Person(1001,"CC"));
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);

    }
}

class Person {

    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}