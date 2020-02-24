package thread.createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 使用线程池创建线程
 * 好处：
 *  提高响应速度（减少了创建新线程的时间）
 *  降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *  便于线程管理
        *  corePoolSize：核心池的大小
        *  maximumPoolSize：最大线程数
        *  keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 * @author cky
 * @create 2020 2 16 11:14
 */

class MyThread4 implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

public class method4 {
    public static void main(String[] args) {
        //创建一个线程池 需要的参数是线程池最大的线程数目
        ExecutorService service = Executors.newFixedThreadPool(10);

        //service.submit(); //适合实现了callable接口的类
        service.execute(new MyThread4());//适合是实现runnable接口的类

        //关闭线程池
        service.shutdown();
    }

}
