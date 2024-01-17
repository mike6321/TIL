package com.example.java.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Arrays;

/**
 * -XX:+UseSerialGC
 * -XX:+UseParallelGC
 * -XX:+UseG1GC
 * */
public class GCProfilingMeta {

    public static void main(String[] args) {
        for (GarbageCollectorMXBean bean : ManagementFactory.getGarbageCollectorMXBeans()) {
            System.out.println("MemoryManager: " + bean.getName());
            System.out.println("MemoryPoolNames: " + Arrays.toString(bean.getMemoryPoolNames()));
        }
    }
}
