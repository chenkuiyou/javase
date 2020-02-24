package collection_and_map.Collection.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * treeset 不能添加Object 对象，添加的对象必须相同；因为要对对象进行排序
 * 遍历就是输出排序好的顺序
 * 使用的对象需要重写 compareTo 对象
 * compareTo 不能返回0 ，返回0无法插入
 *
 * @author cky
 * @create 2020  17 12:07
 */
public class treeset {
    public static void main(String[] args) {

        //定制排序
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
//                if(o1 instanceof User && o2 instanceof User){
////                        User u1 = (User)o1;
////                        User u2 = (User)o2;
////                    return Integer.compare(u1.getAge(),u2.getAge());
////                }else{
////                    throw new RuntimeException("输入的数据类型不匹配");
////                }
                return 1;
            }
        };

        TreeSet set = new TreeSet(com);

    }
}
