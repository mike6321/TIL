package com.example.osiv;

import com.example.osiv.dto.MemberRequest;
import com.example.osiv.dto.TeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/osiv/")
public class OSIVController {

    private final MemberService memberService;
    private final TeamService teamService;

    @PostMapping("member")
    public void createMember(@RequestBody MemberRequest memberRequest) {
        memberService.createMember(memberRequest);
    }

    @PostMapping("team")
    public void createTeam(@RequestBody TeamRequest teamRequest) {
        teamService.createTeam(teamRequest);
    }

}
