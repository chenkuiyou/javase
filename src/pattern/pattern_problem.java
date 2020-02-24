package pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cky
 * @create 2020 2 19 14:28
 */
public class pattern_problem {
    public static void main(String[] args) {
        //范型不带字符类关系
        //正常情况下   父类引用指向子类对象
        String s = new String();
        Object o = new Object();
        o = s;
//        对于范型来说不行
        ArrayList<Object> obj1 = new ArrayList<>();
        ArrayList<String> str = new ArrayList<>();
        //obj=str;  编译不通过， 体现范型带有子父类关系

        //这个时候就要使用通配符
        ArrayList<?> un = new ArrayList<>();
        un = obj1;
        un = str;

        //但是在add的时候会产生问题

        str.add("hello");
        //un.add("hello");  编译不通过
        //但是允许读取数据
        System.out.println(un.get(0));


        // ? extends  ojb
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
        //Student s = list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);
        ////编译不通过
//        Person obj = list2.get(0);

        //写入数据：
        //编译不通过
//        list1.add(new Student());

        //编译通过
        list2.add(new Person());
        list2.add(new Student());
    }
}

class Person{

}

class Student extends  Person{

}
