package ConcurrentDemo.ThreadFor;

public class ThreadForNum {
    private static Object o = new Object();
    public static void main(String[] args) {
        new Thread( new ThreadForNum1() ).start();
        new Thread( new ThreadForNum2() ).start();

    }

    public static class ThreadForNum1 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                synchronized (ThreadForNum.o){
                    System.out.println(1);
                    try {
                        ThreadForNum.o.notify();
                        ThreadForNum.o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class ThreadForNum2 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                synchronized (ThreadForNum.o){
                    System.out.println(2);
                    try {
                        ThreadForNum.o.notify();
                        ThreadForNum.o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
