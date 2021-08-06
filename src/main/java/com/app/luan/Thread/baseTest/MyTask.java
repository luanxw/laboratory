package com.app.luan.Thread.baseTest;

import com.app.luan.Thread.Excute;
import org.apache.poi.ss.extractor.ExcelExtractor;

import java.util.concurrent.*;

public class MyTask implements Callable<String> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        //模拟停留3秒
        Thread.sleep(3000);
        return "线程执行成功！";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        MyTask task = new MyTask();
        //直接提交，借助 Future< >去取值
        Future<String> future = executorService.submit(task);

        //FutureTask已经实现了Runnable接口，调线程池后，能自己取值
        FutureTask<String> futureTask = new FutureTask<>(task);
        executorService.submit(futureTask);
        try {
            Thread.currentThread().setName("线程1");
            System.out.println("线程名称："+Thread.currentThread().getName());
            System.out.println(futureTask.get(2,TimeUnit.SECONDS));
          //  有可能Callable和FutureTask会创建多次。FutureTask能够在高并发环境下确保任务只执行一次
        }catch (TimeoutException e){
            System.out.println("线程1，执行超时了哦！");
        }
        //调用get时会阻塞该线程直到得到结果
        //因此，在实际编码中，使用可以设置超时时间的重载get方法
        try {
            Thread.currentThread().setName("线程2");
            System.out.println("线程名称："+Thread.currentThread().getName());
            System.out.println(future.get(4,TimeUnit.SECONDS));
        }catch (TimeoutException e){
            System.out.println("线程2，执行超时了哦！");
        }
    }

    //有可能Callable和FutureTask会创建多次。FutureTask能够在高并发环境下确保任务只执行一次
}
