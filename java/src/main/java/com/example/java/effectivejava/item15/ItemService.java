package com.example.java.effectivejava.item15;

import java.util.Objects;

public class ItemService {

//    MemberService memberService;
    private MemberService memberService;

    boolean onSale;
    protected int saleRate;

    public ItemService(MemberService memberService) {
        if (Objects.isNull(memberService)) {
            throw new IllegalArgumentException("memberService null");
        }
        this.memberService = memberService;
    }

    MemberService getMemberService() {
        return memberService;
    }

}
