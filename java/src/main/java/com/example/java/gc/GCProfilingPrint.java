package com.example.java.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

public class GCProfilingPrint {

    static String oldGenGcName = "";
    static Map<String, Long> gcStatMap = new HashMap<String, Long>();

    public static void print() {
        long fullGcDelta = 0;
        for (GarbageCollectorMXBean bean : ManagementFactory.getGarbageCollectorMXBeans()) {
            String beanName = bean.getName();
            long newCount = bean.getCollectionCount();
            if (beanName.equals(oldGenGcName)) {
                long oldCount = gcStatMap.get(beanName);
                fullGcDelta = newCount - oldCount;
            }
            gcStatMap.put(beanName, newCount);
        }

        findOldGenGC();
        if (fullGcDelta > 0) {
            System.out.println(yellow(gcStatMap + "OldGenGC is [" + oldGenGcName + "] Full GC #" + fullGcDelta));
        }
    }

    private static void findOldGenGC() {
        if (!oldGenGcName.equals("")) {
            return;
        }

        String foundName = "";
        long minGcCount = Long.MAX_VALUE;
        for (String gcName : gcStatMap.keySet()) {
            long gcCount = gcStatMap.get(gcName);
            if (gcCount < minGcCount) {
                foundName = gcName;
                minGcCount = gcCount;
            } else if (gcCount == minGcCount) {
                foundName = "";
            }
        }
        if (!foundName.equals("")) {
            System.out.println(yellow("Found OldGenGC=" + foundName));
        }
        oldGenGcName = foundName;
    }

    private static String yellow(String str) {
        return "\u001B[32m" + str + "\u001B[0m";
    }
}
