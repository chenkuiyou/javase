package thread.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 通过实现实现Callable接口的方式创建线程
 * 1.创建一个实现callable接口的类，并且重写call()方法
 * 2.创建出这个类的对象对象
 * 3.新建一个FutureTask 的对象并且将上面创建的对象作为参数传入；
 * 4.创建一个线程将上面创建的 FutureTask  对象作为参数传入，并启动线程
 * 5.线程启动后如果想获得重写的call方法中的返回值 需要调用 futureTask.get()方法
 *   这个方法会抛出异常，需要用try catch捕捉
 *
 *
 *
 * Callable接口实现了范型 需要在定义的时候确定范型，这个类型就是call方法的返回值类型
 *
 * callable和runnable接口的区别
 * 1.callable可以实现范型
 * 2.callable 可以有返回值
 * 3.callable 可以有抛出异常
 *
 *
 * @author cky
 * @create 2020 2 15 16:44
 */

class Mymethod3 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int res=0;
        for (int i = 0; i < 100; i++) {
            res+=i;
        }
        return res;
    }
}

public class methon3 {
    public static void main(String[] args) {
        Mymethod3 mymethod3=new Mymethod3();

        FutureTask<Integer> futureTask=new FutureTask<Integer>(mymethod3);

        new Thread(futureTask).start();

        try {
            Integer i=futureTask.get();
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
