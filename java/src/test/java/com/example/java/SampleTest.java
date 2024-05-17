package com.example.java;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log4j2
public class SampleTest {

    @Test
    void test() {

        /*
         * 관찰자1 AutoClosable
         * */
        class Resource1 implements Closeable {

            public void print() {
                log.info("run1!!!!!");
            }

            @Override
            public void close() {
                throw new IllegalStateException();
            }
        }

        /*
         * 관찰자2 AutoClosable
         * */
        class Resource2 implements Closeable {

            public void print() {
                log.info("run2!!!!!");
            }

            @Override
            public void close() {
                log.info("closed2");
            }
        }

        /*
         * 관찰 대상자 try-with-resources
         * */
        class TryCatchRunner<T, Z> {

            final List<AutoCloseable> autoCloseables = new ArrayList<>();

            @SafeVarargs
            public final <Param extends T, Return extends Z> Return runWithTryCatch(Function<Param[], Return> function, Param... params) {
                try {
                    autoCloseables.addAll(Arrays.stream(params)
                            .filter(param -> param instanceof AutoCloseable)
                            .map(param -> (AutoCloseable) param)
                            .collect(Collectors.toList()));

                    return function.apply(params);

                } finally {
                    autoCloseables.forEach(autoCloseable -> {
                        try {
                            autoCloseable.close();
                        } catch (Exception e) {
                            log.error("", e);
                        }
                    });
                }
            }
        }

        String res = new TryCatchRunner<Object, String>().runWithTryCatch(params -> {
            ((Resource1)params[0]).print();
            ((Resource2)params[1]).print();
            return "finished";
        }, new Resource1(), new Resource2());

        log.info(res);

    }
}
