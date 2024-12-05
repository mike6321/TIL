package com.example.designpattern.singletonpattern.phase07;

import java.io.*;

public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Setting setting = Setting.getInstance();

        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream("setting.obj"))) {
            output.writeObject(setting);
        }
        try (ObjectInput input = new ObjectInputStream(new FileInputStream("setting.obj"))) {
            Setting setting2 = (Setting) input.readObject();
            System.out.println(setting == setting2);
        }

    }

}
