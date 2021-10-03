package io.github.qxqrose;

/**
 * @author: qiu
 * 2021/9/19
 */
public class LockTest {

    private static volatile int count = 0;

    static MyLock lock = new MyLock();

    public static void main(String[] args) throws InterruptedException {


        int n = 10;
        for (int i = 0; i < n; i++) {
            new Thread(() -> {
                lock.lock();
                for (int j = 0; j < 1000; j++) {
                    count ++;
                }
                lock.unlock();
            }).start();
        }

        Thread.sleep(1000);

        System.out.println(count);
    }
}
