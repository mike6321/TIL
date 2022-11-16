package com.example.osiv;

import com.example.osiv.dto.MemberRequest;
import com.example.osiv.dto.TeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @GetMapping("team/{id}")
    public Set<Team> getTeam(@PathVariable Long id) {
        Set<Team> teams = teamService.getTeam(id);
        return teams;
    }

}
