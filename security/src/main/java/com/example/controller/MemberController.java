package com.example.controller;

import com.example.dto.ReqCreateMember;
import com.example.dto.ResCreateMember;
import com.example.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<ResCreateMember> signUp(@RequestBody ReqCreateMember reqCreateMember) {
        return ResponseEntity.ok(memberService.createMember(reqCreateMember));
    }

}
