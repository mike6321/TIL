package com.example.java.serialize;

import java.io.*;

class Person implements Serializable {
    private String name;
    private transient int age; // transient로 표시하여 직렬화에서 제외

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // 직렬화: 객체를 파일에 저장
        try {
            Person person = new Person("Alice", 30);

            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Person 객체가 직렬화되어 저장됨.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 역직렬화: 파일에서 객체를 읽어옴
        try {
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person loadedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Person 객체가 역직렬화됨.");
            System.out.println("이름: " + loadedPerson.getName());
            System.out.println("나이: " + loadedPerson.getAge()); // 직렬화에서 제외된 변수의 값은 0이 됨
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
