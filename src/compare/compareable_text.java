package compare;

import java.util.Arrays;

/**
 *
 * 实现Compareble 接口重写 compareTo方法，  实现自然排序
 * compareTo(Object o)
 * 在this 和o对象 进行比较
 * 如果this>o 返回 -1
 * 如果this<o 返回1
 * 相等返回0
 * 这样写出来经过sort 得到的升序序列
 *
 * @author cky
 * @create 2020 2 16 19:23
 */


class Text5 implements Comparable{
    int i;
    String s=null;
    Text5(String s ,int i){
        this.s=s;
        this.i=i;
    }

    @Override
    public String toString() {
        return "Text5{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }
    Text5(){}
    @Override
    public int compareTo(Object o) {
        if(o instanceof  Text5){
            Text5 t=(Text5) o;
            if(t.i>i){
                return -1;
            }
            else if(t.i<i)
                return 1;
            else
                return this.s.compareTo(t.s);
        }
        throw new RuntimeException("数据类型不一致");
    }
}

public class compareable_text {
    public static void main(String[] args) {
        Text5[] t=new Text5[4];
        t[0]=new Text5("hello",0);
        t[1]=new Text5("pello",1);
        t[2]=new Text5("hello",3);
        t[3]=new Text5("hello",1);

        Arrays.sort(t);

        System.out.println(Arrays.toString(t));
    }
}
