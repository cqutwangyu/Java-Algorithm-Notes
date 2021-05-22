package TestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName 并发打印ABCD
 * @Description 并发打印ABCD
 * @Author cqutwangyu
 * @DateTime 2019/3/12 19:29
 * @GitHub https://github.com/cqutwangyu
 */
public class 并发打印ABCD {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int runCount = 4;
        new MyThread("A", atomicInteger, 0, runCount).start();
        new MyThread("B", atomicInteger, 1, runCount).start();
        new MyThread("C", atomicInteger, 2, runCount).start();
        new MyThread("D", atomicInteger, 3, runCount).start();
    }

    static class MyThread extends Thread {
        String word;
        AtomicInteger atomic;
        int order;
        int runCount;

        public MyThread(String word, AtomicInteger atomic, int order, int runCount) {
            this.word = word;
            this.atomic = atomic;
            this.order = order;
            this.runCount = runCount;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (atomic) {
                    if (atomic.get() % runCount == order) {
                        System.out.println(atomic.get() + "," + word + "," + order + "," + runCount);
                        atomic.getAndAdd(1);
                        atomic.notifyAll();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            atomic.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
