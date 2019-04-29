package ConcurrentDemo.ArraayBlockingQueue;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {


    @Test
    public void test1() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(1024);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread( producer ).start();
        new Thread( consumer ).start();
        Thread.sleep(5000);

    }

    public static class Producer implements Runnable{
        protected BlockingQueue queue;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                queue.put("1");
                Thread.sleep(2000);
                queue.put("2");
                Thread.sleep(2000);
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static class Consumer implements Runnable{
        protected BlockingQueue queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
