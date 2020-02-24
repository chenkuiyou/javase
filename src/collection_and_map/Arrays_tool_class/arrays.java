package collection_and_map.Arrays_tool_class;

import java.util.Arrays;

/**
 *
 * Arrays工具类的api
 * @author cky
 * @create 2020 2 17 17:09
 */
public class arrays {
    public static void main(String[] args) {
        int[] l1=new int[]{1,3,2,9,5};
        int[] l2=new int[]{1,2,3,4,5};


//    1 boolean equals(int[] a,int[] b) 判断两个数组是否相等。
        System.out.println(Arrays.equals(l1, l2));
//    2 String toString(int[] a) 输出数组信息。
        System.out.println(Arrays.toString(l1));
//    3 void fill(int[] a,int val) 将指定值填充到数组之中。
        int []l3=new int[5];
        Arrays.fill(l3,9);
        for (int i:l3)
            System.out.println(i);
//    4 void sort(int[] a) 对数组进行排序。
        Arrays.sort(l1);
        System.out.println(Arrays.toString(l1));
//    5 int binarySearch(int[] a,int key) 对排序后的数组进行二分法检索指定的值。
        System.out.println(Arrays.binarySearch(l1, 5)); //返回的是下标值
        System.out.println(Arrays.binarySearch(l1, 6)); //返回的是二分之后的-(low+1)
    }
}
