package com.example.java.effectivejava.item15;

public class DefaultMemberService implements MemberService {

    private String name;

    private static class PrivateStatus {

        void doPrint() {
//            System.out.println(name);
        }

    }

    private class PrivateClass {

        void doPrint() {
            System.out.println(name);
        }

    }

}
