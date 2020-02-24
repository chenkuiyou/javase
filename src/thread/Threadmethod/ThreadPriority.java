package thread.Threadmethod;

/**
 *
 * 线程优先级一共有10级 1最低10最高
 * 平常的优先级为5（默认）
 *  public final static int MIN_PRIORITY = 1;
 *  public final static int NORM_PRIORITY=5;
 *  public final static int MAX_PRIORITY=10;
 *
 *  通过getPriority()查看当前线程的优先级
 *  通过setPriority(int p) 设置线程的优先级
 *
 *  线程创建时继承父线程的优先级
 *  低优先级只是获得调度的概率低，并非一定是在高优先级线程之后才被调用
 * @author cky
 * @create 2020 2 14 17:03
 */

public class ThreadPriority {
    public static void main(String[] args) {

    }
}

