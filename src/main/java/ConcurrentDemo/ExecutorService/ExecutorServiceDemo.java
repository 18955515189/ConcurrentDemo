package ConcurrentDemo.ExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

   public static void main(String[] args) {
      // ExecutorService executor = Executors.newSingleThreadExecutor();
       // ExecutorService executor = Executors.newFixedThreadPool(2);
       ExecutorService executor = Executors.newScheduledThreadPool(2);
       MyRunable myRunable = new MyRunable();
       executor.submit( myRunable );
       executor.submit( myRunable );

       executor.shutdown();

   }
   
   public static class MyRunable implements Runnable{

       @Override
       public void run() {
           for (int i=0;i<10;i++ ){
               System.out.println( Thread.currentThread().getName()+ "德玛西亚 战神"+i);
           }
       }
   }

}
