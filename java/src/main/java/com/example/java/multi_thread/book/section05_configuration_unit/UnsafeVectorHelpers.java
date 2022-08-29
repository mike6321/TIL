package com.example.java.multi_thread.book.section05_configuration_unit;

import java.util.Vector;

public class UnsafeVectorHelpers {

    /**
     * Thread_A -> deleteLast
     * Thread_B -> getLast
     *  -> ArrayIndexOutOfBoundsException
     * */
    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static Object deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.remove(lastIndex);
    }

}
