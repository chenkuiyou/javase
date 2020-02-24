package thread.createThread;

/**
 *
 * 创建线程方式1 继承Thread 重写run方法然后在main中创建对象
 *
 * @author cky
 * @create 2020 2 14 12:09
 */

class MyThread extends Thread{
    @Override

    public void run() {  //run方法中所写内容就是 此线程的功能
        for (int i = 0; i <100 ; i++) {
            System.out.println(i+Thread.currentThread().getName());
        }
    }
}

public class method1 {
    public static void main(String[] args) {
       MyThread t1=new  MyThread();
       t1.setName("线程1");
       t1.start();
       //t1.run();  调用了run方法是相当于调用了一个函数，是顺序执行，没有开启另一个线程
        //通过 Thread.currentThread().getName(); 获得当前线程
        for (int i = 0; i <100 ; i++) {
            System.out.println(i+Thread.currentThread().getName());
        }
    }
}
