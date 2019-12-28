package com.singer.thread;

/**
 * 普通多线程
 * @author lujianrong
 */
public class BaeThread {
    public static void main(String[] args) {

        MyThread t1 = new MyThread("AAAAAAAA");
        MyThread t2 = new MyThread("BBBBBB");
        MyThread t3 = new MyThread("CCCC");

        t1.start();
        t2.start();
        t3.start();

        MyRunable r4 = new MyRunable("AAAAAAAA");
        MyRunable r5 = new MyRunable("BBBBBB");
        MyRunable r6 = new MyRunable("CCCC");
        Thread t4 = new Thread(r4);
        Thread t5 = new Thread(r5);
        Thread t6 = new Thread(r6);

        t4.start();
        t5.start();
        t6.start();


    }
}


/**
 * 继承Thread类
 */
class MyThread extends Thread {
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= 10) {
            System.out.println(this.threadName + ":" + i);
            i++;
        }
    }
}


/**
 * 实现Runnable接口
 */
class MyRunable implements Runnable {
    private String threadName;

    public MyRunable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= 10) {
            System.out.println(this.threadName + ":" + i);
            i++;
        }
    }
}