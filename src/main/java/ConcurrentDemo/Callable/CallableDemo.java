package ConcurrentDemo.Callable;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable cl = new MyCallable();// 实例化Callable子类对象

        FutureTask<String> ft = new FutureTask<String>(cl);// 实例化FutureTask对象，并将Callable子类对象传入FutureTask的构造方法中

        new Thread(ft, "李存孝部队——>").start();// 启动线程

        Thread.currentThread().setName("李存勖部队——>");// 设置父线程名

        try {

            System.out.println(Thread.currentThread().getName() + "休整5000ms");

            Thread.sleep(5000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        System.out.println(Thread.currentThread().getName() + "休整完毕..");

        try {

            String str = ft.get();// 利用FutureTask对象调用get()方法获取子线程的返回值

            System.out.println(Thread.currentThread().getName() + "获取友军消息"

                    + str);

        } catch (InterruptedException | ExecutionException e) {

            e.printStackTrace();

        }

    }


    public static class MyCallable implements Callable {

        @Override
        public Object call() {
            String th_name = Thread.currentThread().getName();

            System.out.println(th_name + "遭遇大规模敌军突袭...");

            System.out.println(th_name + "迅速变换阵型...");

            System.out.println(th_name + "极速攻杀敌军...");

            return "敌军损失惨重，我军大获全胜";
        }
    }
}
