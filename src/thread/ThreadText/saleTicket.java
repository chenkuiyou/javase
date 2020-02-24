package thread.ThreadText;

/**
 *
 * 三个窗口共卖100张票
 *  需要将Window1 线程的tickte属性设置为static
 * 在采用继承的方式创建的线程 在要实现线程安全问题的时候大部分都是加上static
 * @author cky
 * @create 2020 2 14 17:24
 */
class Window1 extends  Thread{
    private  static int ticket=100;
    //private  static Object obj=new Object();
    @Override
    public void run() {
        while (true){
            if(show());   //采用同步方法
            else break;



//            synchronized (Window1.class){   //这里采用同步代码块的方法

//                if(ticket>0){
//                    try {
//                        sleep(50);
//                    } catch (Exception e){
//                        e.printStackTrace();
//                    }
//                    System.out.println(getName()+":" +ticket);
//                    ticket--;
//                }
//                else { 
//                    break;
//                }
//            }

        }
    }
    public static synchronized  boolean show(){  //这里的同步监视器（锁） 是类本身

            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+":" +ticket);
                ticket--;
                return true;
            }
            else return false;

    }
}

public class saleTicket {
    public static void main(String[] args) {
        Window1 window1=new Window1();
        Window1 window2=new Window1();
        Window1 window3=new Window1();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}
