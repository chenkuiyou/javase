package thread.createThread;

/**
 * 创建线程方法2
 * 1.定义一个实现了runnable接口的类
 * 2.重写这个类的run方法
 * 3.创建一个这样的类
 * 4.把这个类做为参数去创建一个Thread对象
 * 5.执行Thread对象的run方法
 *
 * 在开发中建议使用第二种，因为有天然的共享数据，主要是第二种不需要继承父类，实现了接口能再次实现一个父类
 *
 * @author cky
 * @create 2020 2 14 17:07
 */
class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

public class methon2 {
    public static void main(String[] args) {
        MyThread2 t=new MyThread2();
        Thread i1=new Thread(t);
        i1.start();
        //如果还想再次开一个和i一样的线程
        //t可以共用 i1与i2是公用一个对象的 如果在t对象中有有某个参数 这个参数对于两个线程来说共用
        Thread i2=new Thread(t);
        i2.start();
    }
}
