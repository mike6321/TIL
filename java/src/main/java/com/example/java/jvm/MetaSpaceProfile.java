package com.example.java.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

/**
 * -XX:MaxMetaspaceSize=55458184
 * -XX:MetaspaceSize=1082130432
 * */
public class MetaSpaceProfile {

    private static long lastGcCount = 0;

    public static void main(String[] args) throws InterruptedException {
        long pid = ProcessHandle.current().pid();
        System.out.println("PID: " + pid);
        List<ClassLoader> loaders = new ArrayList<>();

        // 1,082,130,432

        while (true) {
            ClassLoader tempLoader = new ClassLoader() {};
            loaders.add(tempLoader); // 클래스 로더 저장

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyClass.class);
            enhancer.setUseCache(false); // 캐시 사용하지 않도록 설정
            enhancer.setCallback((FixedValue) () -> "Hello Metaspace");

            MyClass myClass = (MyClass) enhancer.create();
            System.out.println(myClass.toString());

            logFullGcEventsAndMetaspaceUsage();

//            if (loaders.size() > 1000) { // 임계값 도달 시
//                loaders.clear(); // 리스트 비우기로 클래스 로더 참조 해제
//                System.gc(); // 가비지 컬렉션 요청
//                Thread.sleep(1000); // 잠시 대기
//
//                System.out.println("!!!!");
//                logFullGcEventsAndMetaspaceUsage();
//            }
        }
    }

    private static void logFullGcEventsAndMetaspaceUsage() {
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            long count = gcBean.getCollectionCount();
            if (count > lastGcCount) {
                System.out.println("Full GC occurred! GC Name: " + gcBean.getName() + ", Count: " + count);
                logMetaspaceUsage();
                lastGcCount = count;
            }
        }
    }

    private static void logMetaspaceUsage() {
        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (pool.getName().contains("Metaspace")) {
                MemoryUsage usage = pool.getUsage();
                long used = usage.getUsed();
                long max = usage.getMax();
                System.out.println("Metaspace used: " + used + " bytes");
                System.out.println("Metaspace max: " + max + " bytes");
                break;
            }
        }
    }

}
