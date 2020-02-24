package Enum;

import java.util.Arrays;

/**
 *
 * 一 枚举类的使用
 * 1.枚举类的对象是确定的，有限个
 * 2.需要定于一组常量的时候，通常使用枚举类
 * 3.如果枚举类中的对象只有一个，通常使用单例模式
 *
 * 枚举类的定义
 * 1.自定义 在jdk5.0之前
 * 2.使用关键字 enum  enum 的父类不是Object 是  class java.lang.Enum
 *
 *
 * 二 enum枚举类的常用方法
 * 1.toString()
 * 2.values()  返回当前枚举类的全部形态 以数组形式返回
 *          season2 [] s=season2.values();
 * 3.valueOf( String  objname)  根据objname去寻找
 *
 *三 使用enum实现 接口 可以对每个对象定制同名不同函数的接口抽象类
 *
 *
 *
 * 线程中有个属性State就是enum 定义的，可以返回
 * System.out.println(Arrays.toString(Thread.State.values()));
 *
 *
 * @author cky
 * @create 2020 2 17 10:09
 */

//自定义枚举类
class season1{
    private final String seasonName;
    private season1(String seasonName){
        this.seasonName=seasonName;
    }
    public static final season1 SPRING=new season1("春天");
    public static final season1 SUMMER=new season1("夏天");
    public static final season1 AUTUMN=new season1("秋天");
    public static final season1 WINTER=new season1("冬天");

    public String getSeasonName() {
        return seasonName;
    }

    @Override
    public String toString() {
        return "season1{" +
                "seasonName='" + seasonName + '\'' +
                '}';
    }
}

interface  inter{
    void show();
}


enum  season2  implements inter {
    //  public static final season1 SPRING=new   season1("春天");
    //下面的格式等同于上面的定义方式 而且定义 必须写在第一行
    SPRING("春天"){
        @Override
        public void show() {
            System.out.println("Spring is where");
        }
    },
    SUMMER("夏天"){
        @Override
        public void show() {
            System.out.println("Summer is hot");
        }
    },
    AUTUMN("秋天"){
        @Override
        public void show() {
            System.out.println("Autumn is fast");
        }
    },
    WINTER("冬天"){
        @Override
        public void show() {
            System.out.println("Winter is cold");
        }
    };
    private final String seasonName;
    private season2(String seasonName){
        this.seasonName=seasonName;
    }

    //不用重写toString 方法 系统会帮你重写
    @Override
    public String toString() {
        return "season1{" +
                "seasonName='" + seasonName + '\'' +
                '}';
    }


    @Override
    public void show() {

    }
}

public class text {
    public static void main(String[] args) {

        System.out.println(season1.AUTUMN);
        System.out.println(season2.WINTER);

        //enum 的父类不是Object方法
        System.out.println(season2.class.getSuperclass());


        season2[] s= season2.values();

        System.out.println(Arrays.toString(s));

        season2 s2= season2.valueOf("WINTER");

        System.out.println(s2);

        s2.show();
    }
}
