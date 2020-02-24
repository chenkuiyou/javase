package collection_and_map.Collection.list;

import java.util.ArrayList;

/**
 *
 * arraylist源码分析
 * 在jdk7和jdk8的源码不同
 *  jdk7
 *      在创建一个arraylist时：   ArrayList list=new ArrayList();
 *      会自动申请一个长度为10 的数组 然后每次扩容1.5背
 *      扩容就是申请一个新长度的数组，将原来的数组中的内容copy过去
 *   jdk8
 *      在创建一个arraylist的时候，不会先分配10长度的数组，而是在add
 *      的时候去动态申请长度，默认长度也是10，其他没什么区别
 *
 *   类似于单例模式的 懒汉式（jdk8）和饿汉式（jdk7）
 *   便于理解，懒，能 托多久托多久，要的时候再去创建
 *
 * @author cky
 * @create 2020 2 17 12:07
 */
public class arraylist {
    public static void main(String[] args) {
        ArrayList list=new ArrayList();

//        void add(int index, Object ele):在index位置插入ele元素
//        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
//        Object get(int index):获取指定index位置的元素
//        int indexOf(Object obj):返回obj在集合中首次出现的位置
//        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
//        Object remove(int index):移除指定index位置的元素，并返回此元素
//        Object set(int index, Object ele):设置指定index位置的元素为ele
//        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合


    }
}
