package com.lydeliver.algorithm;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName BInaryToInt
 * @Author jonathan
 * @Date 2018/10/28 3:52 PM
 * @Version 1.0
 * @Description TODO
 */
public class BInaryToInt {

    public void permutation() {
    }



    public static void main(String[] args) throws ExecutionException,
            InterruptedException  {
        System.out.println("----程序开始运行----");
        Date date1 = new Date();

        ExecutorService pool = Executors.newFixedThreadPool(5);

        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MyCallable able = new MyCallable(i+" ");
            Future f = pool.submit(able);
            list.add(f);
        }

        for (Future f : list) {
            System.out.println(f.get().toString());
        }
    }




}

class MyCallable implements Callable<Object> {
    private String taskNum;

    MyCallable(String taskNum) {
        this.taskNum = taskNum;
    }

    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }
}