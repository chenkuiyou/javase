package thread.ThreadText;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个窗口共卖100张票  用实现runnable接口的类实现
 *
 * 但是不要将ticket 设置为static 因为三个Thread共用一个 Window2 对象
 *
 *  解决线程安全问题的方法
 *  1. 同步代码块
 *      将会出现线程安全的代码块用synchronized （）{}包括起来
 *      synchronized （同步监视器）{  同步监视器是一个对象，作用是作为一个锁 要求会出现线程安全的线程公共用一个对象
 *          会出现线程安全的代码块
 *      }
 *  2.同步方法
 *      如果某个方法会出现线程安全问题，则不妨将此方法设置为同步方法
 *      在方法中加上 synchronized
 *      如果在继承的方法中使用 synchronized
 *      需要在函数中加入 static
 *  3. lock锁 jdk 5.0新增
 *      private ReentrantLock lock=new ReentrantLock(boolean );
 *      先定义一个锁 然后将会出现线程安全问题的代码用try包住 在try之前执行 lock.lock（） 在finally中执行lock.unlock（）；
 *      lock.lock();
 *      try {
 *         会出现线程安全的代码块
 *      }finally {
 *         lock.unlock();
 *      }
 *      ReentrantLock 有两个构造函数， 无参构造函数默认 参数fair的值为false
 *      fair=flase 指的是解锁之后  出现线程安全的代码块还是抢夺CPU的资源，不会按照排队顺序进行
 *      fair=true  指的是需要执行的代码块被lock后会在代码块外进行排队，先到先进入
 *
 * lock与synchronized的区别
 * 相同：都能解决线程安全问题
 * 不同：lock属于手动开锁 ，synchronized的区别属于自动开锁
 *
 * @author cky
 * @create 2020 2 14 17:32
 */

class Window2 implements Runnable{

    private int ticket=100;

    private ReentrantLock lock=new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
//    第二种        if(show());   //采用同步方法
//            else break;

//第三种
            lock.lock();
            try {
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+":" +ticket);
                    ticket--;
                }
                else {
                    break;
                }
            }finally {
                lock.unlock();
            }





//   第一种         synchronized (this){  //采用同步代码块的方式
////                if(ticket>0){
////                    System.out.println(Thread.currentThread().getName()+":" +ticket);
////                    ticket--;
////                }
////                else {
////                    break;
////                }
//            }

        }
    }
    public synchronized  boolean show(){  //这里的同步监视器（锁） 就是this
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+":" +ticket);
                ticket--;
                return true;
            }
            else return false;
    }
}

public class saleTicket2 {
    public static void main(String[] args) {
        Window2 w=new Window2();

        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

