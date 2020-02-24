package collection_and_map.Map;

import java.util.*;

/**
 * map中的方法
 *  添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 * @author cky
 * @create 2020 2 19 10:18
 */
public class APItest {
    public static void main(String[] args) {
        HashMap map=new HashMap();
        Map<Integer,String > map1=new HashMap<Integer, String>();
        map.put(123,"hello");
        map.put(456,"world");
        map1.putAll(map);
        System.out.println(map1);
        map1.remove(456);
        System.out.println(map1);

        System.out.println(map1.get(123));
        System.out.println(map1.containsKey(123));
        System.out.println(map1.containsValue("hello"));
        System.out.println(map1.size());
        System.out.println(map1.isEmpty());
        //要想返回true 必须也是map且里面内容一样
        System.out.println(map1.equals(123));
        System.out.println(map1.equals(map1));


        System.out.println("**************");
        //map 中没有迭代器
        Set set=map1.keySet();
        System.out.println(set);
        Collection c=map.values();
        System.out.println(c);
        Set set1=map1.entrySet();  //set中的类型 class java.util.HashMap$Node


        //遍历map方式1
        for(Object i: set1){
            System.out.println(i.getClass());
            Map.Entry e=(Map.Entry) i;
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            System.out.println(e.setValue("hello world")); //返回的是旧的value 在这里修改 ，相应的map也修改
        }
        System.out.println(set1);
        //遍历map 方式2
        Set s=map1.keySet();
        Iterator i=s.iterator();
        while (i.hasNext()){
            //  i.next()  这个是key的值
            System.out.println(map1.get((Integer) i.next()));
            //map1.put((Integer) i.next(),"hello11111");
        }
        System.out.println(set1);

    }
}
