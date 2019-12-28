package com.singer.thread;

/**
 * 饿汉模式单例考虑多线程
 * @author lujianrong
 */
public class SingleDemo {

    public static void main(String[] args) {

        Single single = Single.getInstance();

    }
}

class Single {
    private static Single single = null;

    private Single() {
    }

    public static Single getInstance() {

        if (single == null) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }
}