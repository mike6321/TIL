package com.example.java.multi_thread.book.section02_thread_safety;

class Parent {

    public void doSomething() {

    }

}

class Child extends Parent {

    public synchronized void doSomething() {
        super.doSomething();
    }

}


