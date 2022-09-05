package com.example.java.multi_thread.book.section05_configuration_unit.futuretask;


public class LaunderThrowable {

    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException)
            return (RuntimeException) t;
        else if (t instanceof Error)
            throw (Error) t;
        else
            throw new IllegalStateException("Not unchecked", t);
    }

}
