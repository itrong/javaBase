package com.singer.jdk8.lambda;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Lambda表达式范例
 *
 * @author lujianrong
 */


public class TestLambda {

    /**
     * 语法格式一：无参数，无返回值
     * () -> System.out.println("Hello Lambda!");
     * <p>
     * 语法格式二：有一个参数，并且无返回值
     * (x) -> System.out.println(x)
     * <p>
     * 语法格式三：若只有一个参数，小括号可以省略不写
     * x -> System.out.println(x)
     * <p>
     * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句
     * Comparator<Integer> com = (x, y) -> {
     * System.out.println("函数式接口");
     * return Integer.compare(x, y);
     * };
     * <p>
     * 语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
     * Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
     * <p>
     * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
     * (Integer x, Integer y) -> Integer.compare(x, y);
     * <p>
     * <p>
     * Java8 内置的四大核心函数式接口
     * <p>
     * Consumer<T> : 消费型接口
     * void accept(T t);
     * <p>
     * Supplier<T> : 供给型接口
     * T get();
     * <p>
     * Function<T, R> : 函数型接口
     * R apply(T t);
     * <p>
     * Predicate<T> : 断言型接口
     * boolean test(T t);
     */
    @Test
    public void test() {


        testConsumer1(10, (m) -> System.out.println(m));
        testConsumer1(10, m -> System.out.println(m));
        testConsumer1(10, System.out::println);

        Double aDouble = testSupplier(() -> new Double(22));
        aDouble = testSupplier(() -> 22d);
        aDouble = testSupplier(() -> Math.random());
        aDouble = testSupplier(Math::random);
        aDouble = testSupplier(() -> 2.5);

        testFunction(9527, (m) -> m.longValue());
        testFunction(9527, Integer::longValue);
        testFunction(9527, (m) -> new Long(12L));
        testFunction(9527, (m) -> new Long(12L));
        testFunction(9527, (m) -> (12L));
        testFunction(9527, m -> (12L));

        testPredicate(12, (m) -> m > 10);
        testPredicate(12, (m) -> 1 > 10);
        testPredicate(12, m -> 1 > 10);

    }

    public void testConsumer1(Integer integer, Consumer consumer) {
        consumer.accept(integer);
    }

    public Double testSupplier(Supplier<Double> supplier) {
        Double aDouble = supplier.get();
        return aDouble;
    }

    public Long testFunction(Integer ad, Function<Integer, Long> function) {
        Long apply = function.apply(ad);
        return apply;
    }

    public Boolean testPredicate(Integer ad, Predicate<Integer> predicate) {
        Boolean aBoolean = predicate.test(ad);
        return aBoolean;
    }

    /**
     * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
     * （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
     * <p>
     * 1. 对象的引用 :: 实例方法名
     * <p>
     * 2. 类名 :: 静态方法名
     * <p>
     * 3. 类名 :: 实例方法名
     * <p>
     * 注意：
     * ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
     * ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
     * <p>
     * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
     * <p>
     * 1. 类名 :: new
     * <p>
     * 三、数组引用
     * <p>
     * 类型[] :: new;
     */
    @Test
    public void test1() {

        Supplier<TestLambda> supplier = TestLambda::new;
        Supplier<TestLambda> supplier1 = new Supplier<TestLambda>() {
            @Override
            public TestLambda get() {
                return null;
            }
        };

        Function<Integer, TestLambda[]> fun2 = TestLambda[]::new;
        Supplier<TestLambda[]> supplier2 = new Supplier<TestLambda[]>() {
            @Override
            public TestLambda[] get() {
                return null;
            }

        };

    }


}
