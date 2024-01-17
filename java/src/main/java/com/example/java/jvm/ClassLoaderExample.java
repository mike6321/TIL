package com.example.java.jvm;

import java.net.URLClassLoader;

import static java.util.Objects.isNull;

public class ClassLoaderExample {

    public static void main(String[] args) {
        ModuleLayer moduleLayer = ModuleLayer.boot();
        moduleLayer.modules().forEach(module -> {
            ClassLoader classLoader = module.getClassLoader();
            String classLoaderName = isNull(classLoader) ? "bootstrap" : classLoader.getName();
            System.out.println(classLoaderName + ": " + module.getName());
        });
    }

}
