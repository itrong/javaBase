package com.singer.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuturePrime {

    /**
     * 自定义线程池，也可使用系统默认
     */
    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    /**
     * 线程执行对象
     */
    public static Tesk tesk = new Tesk();

    public static void main(String[] args) throws Exception {

        // runAsync 用于执行没有返回值的异步任务
        CompletableFuture<Void> runAsyncResp = CompletableFuture.runAsync(tesk::zero,executor)
                .exceptionally(e -> {
                    System.out.println("Zero出错！");
                    return null;
                });

        // supplyAsync方法用于执行带有返回值的异步任务
        CompletableFuture<String> supplyAsyncRes = CompletableFuture.supplyAsync(() -> tesk.onlyReturn(),executor)
                .exceptionally(e -> {
                    System.out.println("onlyReturn出错！");
                    return null;
                });

        CompletableFuture<String> supplyAsyncRes2 = CompletableFuture.supplyAsync(() -> tesk.inAndReturn("1"),executor)
                .exceptionally(e -> {
                    System.out.println("inAndReturn出错！");
                    return null;
                });

        // thenCompose方法用于连接两个CompletableFuture任务，如下代表supplyAsync结束后将执行结果交由另外一个CompletableFuture处理，然后将执行链路最终赋值给thenCompose
        CompletableFuture<String> thenComposeResp = supplyAsyncRes.thenCompose(re ->
                CompletableFuture.supplyAsync(() -> tesk.inAndReturn(re),executor)
        ).exceptionally(e -> {
            System.out.println("inAndReturn出错！");
            return null;
        });

        // thenAccept方法用于将一个任务的结果，传给需要该结果的任务，如下表示supplyAsync的执行需要supplyAsyncRes的结果，与thenApply不同的是，这个方法没有有返回值
        CompletableFuture<Void> thenAcceptResp = supplyAsyncRes.thenAccept(re ->
                CompletableFuture.supplyAsync(() -> tesk.inAndReturn(re),executor)
        ).exceptionally(e -> {
            System.out.println("inAndReturn出错！");
            return null;
        });

        // thenCombine方法用于连接多个异步任务的结果，如下ab方法需要futureA和futureB的执行结果，那么就可以使用thenCombine进行连接
        CompletableFuture<String> thenCombineResp = supplyAsyncRes.thenCombine(supplyAsyncRes2, (a, b) -> tesk.twoInAndReturn(a, b))
                .exceptionally(e -> {
                    System.out.println("twoInAndReturn出错！");
                    return null;
                });

        CompletableFuture.allOf(runAsyncResp, supplyAsyncRes, supplyAsyncRes2, thenComposeResp, thenAcceptResp, thenCombineResp).get();

        System.out.println("=======================");
        System.out.println(runAsyncResp.get());
        System.out.println(supplyAsyncRes.get());
        System.out.println(supplyAsyncRes2.get());
        System.out.println(thenComposeResp.get());
        System.out.println(thenAcceptResp.get());
        System.out.println(thenCombineResp.get());
        System.out.println("=======================");

        // executor.isTerminated(); 判断子线程任务是否执行完
        executor.shutdown();
    }


}
