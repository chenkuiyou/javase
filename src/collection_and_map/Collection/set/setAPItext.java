package collection_and_map.Collection.set;

import java.util.HashSet;

/**
 *
 * set的三个实现类   无序不可重复的数据结构
 * 不可重复是用equals的方法去判断的，不能返回true 返回ture不能添加；
 * 无序是指内部按照哈希的顺序进行排序了
 *     一.对比
 *      hashset  线程不安全，可以存null
 *          linkedhashset   作为hashset的子类  遍历内部数据可按照添加顺序遍历
 *  *          对于频繁的遍历操作，LinkedHashSet效率高于HashSet
 *  *      treeset   可以按照添加元素指定属性进行排序
 *  *
 *
 *    二.添加元素的过程：以HashSet为例：
 *  *         我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
 *  *         此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置），判断
 *  *         数组此位置上是否已经有元素：
 *  *             如果此位置上没有其他元素，则元素a添加成功。 --->情况1
 *  *             如果此位置上有其他元素b(或以链表形式存在的多个元素），则比较元素a与元素b的hash值：
 *  *                 如果hash值不相同，则元素a添加成功。--->情况2
 *  *                 如果hash值相同，进而需要调用元素a所在类的equals()方法：
 *                        equals()返回true,元素a添加失败
 *                        equals()返回false,则元素a添加成功。--->情况2
 *
 *         对于添加成功的情况2和情况3而言：元素a 与已经存在指定索引位置上数据以链表的方式存储。
 *         jdk 7 :元素a放到数组中，指向原来的元素。
 *         jdk 8 :原来的元素在数组中，指向元素a
 *         总结：七上八下  （7是头插法，8是尾插法）
 *
 *
 *          要使用*set类 就要重写equals和hashcode方法
 *          hashset底层是用 数组+链表实现的  邻接表
 *          //java规定
 *         hashcode一样equal不一定是true ，equals是ture一样hashcode一定一样。
 *
 * @author cky
 * @create 2020 2 18 10:34
 */
public class setAPItext {
    public static void main(String[] args) {
        HashSet s=new HashSet();
        Object o=new Object();
        System.out.println(o.toString());
    }
}
