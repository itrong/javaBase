package com.singer.jdk8.forkjoin;

import org.junit.Test;

import java.util.stream.LongStream;

/**
 * description: --类描述
 *
 * @author lujianrong
 */

public class TestForkJoin {


    @Test
    public void test2(){

        long start = System.currentTimeMillis();

        long sum = 0L;

        for (long i = 0L; i <= 10000000000L; i++) {
            sum += i;
        }

        System.out.println(sum);

        long end = System.currentTimeMillis();

        System.out.println("耗费的时间为: " + (end - start)); //34-3174-3132-4227-4223-31583
    }

    @Test
    public void test3(){
        long start = System.currentTimeMillis();

        Long sum = LongStream.rangeClosed(0L, 10000000000L)
                .parallel()
                .sum();

        System.out.println(sum);

        long end = System.currentTimeMillis();

        System.out.println("耗费的时间为: " + (end - start)); //2061-2053-2086-18926
    }

}
