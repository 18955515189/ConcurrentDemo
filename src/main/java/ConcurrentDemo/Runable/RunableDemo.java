package ConcurrentDemo.Runable;

public class RunableDemo {
    public static void main(String[] args) {
        Runable3 runable3 = new Runable3();
        new Thread( runable3,"窗口A" ).start();
        new Thread( runable3,"窗口B" ).start();



    }

    public static class Runable1 implements Runnable{
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

    public static class Runable2 implements Runnable{
        private int id = 10;
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                synchronized (this){
                    if(id>0){
                        System.out.println( Thread.currentThread().getName()+"卖了编号为"+id+"的火车票" );
                        id--;
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Runable3 implements Runnable{

        private int id =10;
        public synchronized void saleOne(){
            if(id>0){
                System.out.println( Thread.currentThread().getName()+"卖了编号为"+id+"的火车票" );
                id--;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                saleOne();
            }
        }
    }
}
