package com.singer.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 采用线程池的多线程
 *
 * @author lujianrong
 */
public class ExecutorsThread {


    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < 50; i++) {
            integers.add(i);
        }
        printInteger(integers);
    }



    /**
     * 获取线程池并绑定线程任务执行
     */
    private static void printInteger(List<Integer> integers) {

        ExecutorService executorService = Executors.newFixedThreadPool(integers.size());
        for (Integer integer : integers) {
            executorService.execute(
                    () -> {
                        try {
                            System.out.println(integer);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
        executorService.shutdown();//关闭线程池
        //判断是否所有的线程已经运行完，若未运行完，则主线程等待其他线程执行完成再往下执行
        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
