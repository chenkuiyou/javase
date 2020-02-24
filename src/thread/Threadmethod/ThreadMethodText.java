package thread.Threadmethod;

/**
 *
 * 用于测试thread常用方法
 * 1.Thread.currentThread()  获取当前线程，
 * 2.setName(String s)  设置线程名字
 * 3.yeild() 释放当前线程占据的cpu 让线程重新抢占cpu ，可能当前线程还能抢占到cpu
 * 4.join() 在线程a中调用线程b的join（）方法，会让线程a阻塞，直到线程b执行完之后再调用线程a
 * 5.sleep(long m) 使当前线程睡眠m毫秒 在这期间此线程不会抢占cpu资源 时间到了之后线程重新参与抢占cpu资源
 * 6.stop() 过时了，使当前线程结束
 * 7.isAlive() 查看当前线程执行完没有
 * 8.wait() 使当前线程阻塞，并释放同步监视器
 * 9.notify() 唤醒一个线程 优先级高的优先
 * 10.notyfyAll()  唤醒全部线程
 *
 * wait和sleep的区别
 * 相同 都使线程阻塞
 * 不同：1.sleep不会释放同步监视器 wait会
 *       2.sleep的申明是在Thread中 wait的声明式在Object中（任何对象都能调用wait方法）
 *       3. sleep 在哪里都能使用， wait只能使用在同步代码块或者同步方法中。
 *
 * 说明:
 * 1.wait(),notify(),notifyAll()必须放在同步方法或者同步代码块中 lock锁的方法有其他方法实现线程通信
 * 2. 上面三个方法的调用者都是同步方法或者同步代码块中的 同步监视器  否则会抛异常
 * 3. 上面这三个方法是在Object 中定义的，因为任何方法都能充当同步监视器
 *
 * @author cky
 * @create 2020 2 14 12:36
 */
class TextThread implements  Runnable{
    private int m=100;
    @Override
    public void run() {
        while(true){
            synchronized (this){
                notify();
                if(m>0){
                    System.out.println(Thread.currentThread().getName()+" "+m);
                    m--;
                    try {//
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    break;
                }



            }
        }

    }
}

public class ThreadMethodText {
    public static void main(String[] args) {
        TextThread t=new TextThread();

        Thread t1=new Thread(t);
        Thread t2=new Thread(t);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
