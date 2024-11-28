import java.util.concurrent.*;

/**
 * @author csw
 * @date 2022/3/22 17:25
 */
public class ExecutorTest {
    private static ExecutorService executor = Executors.newFixedThreadPool(15);

    //创建线程池的正确姿势
    private static ExecutorService exec = new ThreadPoolExecutor(10,
            10,
            60L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue(10));

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executor.execute(new SubThread());
        }
    }
}

class SubThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) { //do nothing
        }
    }


}
