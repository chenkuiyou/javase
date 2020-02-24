package compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 *  订制排序
 *  Comporator
 *  只实现一次，不是写在类的内部。
 * @author cky
 * @create 2020 2 16 19:38
 */

class Texti {
    int i;
    String s=null;
    Texti(String s ,int i){
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
    Texti(){}

}

public class comparetor_text {
    public static void main(String[] args) {
        Texti[] t=new Texti[4];
        t[0]=new Texti("hello",0);
        t[1]=new Texti("pello",1);
        t[2]=new Texti("hello",3);
        t[3]=new Texti("hello",1);


        Arrays.sort(t, new Comparator<Texti>() {
            @Override
            public int compare(Texti o1, Texti o2) {
                if(o1.i>o2.i){
                    return -1;
                }
                else if(o1.i<o2.i)
                    return 1;
                else
                    return o1.s.compareTo(o2.s);
            }
        });

        System.out.println(Arrays.toString(t));
    }
}
