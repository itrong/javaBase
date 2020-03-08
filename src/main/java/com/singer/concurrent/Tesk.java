package com.singer.concurrent;

import static java.lang.Thread.sleep;

public class Tesk {

    public void zero() {
        try {
            sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("zero方法触发！");
    }

    public String onlyReturn() {
        try {
            sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("onlyReturn方法触发！");
        return "onlyReturn";
    }

    public String inAndReturn(String a) {
        try {
            sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("inAndReturn方法触发！");
        return a;
    }

    public String twoInAndReturn(String a, String b) {
        try {
            sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("twoInAndReturn方法触发！");
        return a + "|" + b;
    }

    public void onlyIn(String a) {
        try {
            sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("onlyIn方法触发！");
    }
}
