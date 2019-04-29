package ConcurrentDemo.Thread;

public class ThreadDemo {
    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();

    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<9;i++){
                System.out.println("i1 = "+i);
            }
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<9;i++){
                System.out.println("i2 = "+i);
            }
        }
    }
}
