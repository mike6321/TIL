package com.example.java.effectivejava.item15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    MemberService memberService;

    @Test
    void itemServiceTest() {
        // DefaultMemberService 참조 불가
        // ItemService itemService = new ItemService();

        ItemService itemService = new ItemService(memberService);
        assertNotNull(itemService);
        // 내부 구현이기 떄문에 package private 으로 변경
//        assertNotNull(itemService.memberService);
        assertNotNull(itemService.getMemberService());
    }

}
