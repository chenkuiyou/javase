package thread.Singleton;

/**
 *
 * 没有线程安全问题的懒汉式单例模式
 *
 * @author cky
 * @create 2020 2 15 10:03
 */

class Month{
    private  static  Month month=null;
    private  Month(){

    }
    public static Month getMonth(){
        if(month==null){
            synchronized (Month.class){
                if(month==null){
                    month=new Month();
                }
            }
        }
        return month;
    }
}

public class SingleTon {

}
