package collection_and_map.Map;

/**
 *
 * map key-value
 *  * 一、Map的实现类的结构：
 *  *  |----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
 *  *         |----HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
 *  *              |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *  *                      原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *  *                      对于频繁的遍历操作，此类执行效率高于HashMap。
 *  *         |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *  *                      底层使用红黑树
 *  *         |----Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
 *  *              |----Properties:常用来处理配置文件。key和value都是String类型
 *  *
 *  *
 *  *      HashMap的底层：数组+链表  （jdk7及之前）
 *  *                    数组+链表+红黑树 （jdk 8）
 *
 * @author cky
 * @create 2020 2 18 12:41
 */
public class maptext {
    public static void main(String[] args) {

    }
}
