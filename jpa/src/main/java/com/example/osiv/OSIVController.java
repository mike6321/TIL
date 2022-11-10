package com.example.osiv;

import com.example.osiv.dto.MemberRequest;
import com.example.osiv.dto.TeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManagerFactory;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/osiv/")
public class OSIVController {

    private final MemberService memberService;
    private final TeamService teamService;
    private final EntityManagerFactory entityManagerFactory;

    @PostMapping("member")
    public void createMember(@RequestBody MemberRequest memberRequest) {
        memberService.createMember(memberRequest);
    }

    @PostMapping("team")
    public void createTeam(@RequestBody TeamRequest teamRequest) {
        teamService.createTeam(teamRequest);
    }

    /**
     * open-in-view: true
     *  success
     *
     * open-in-view: false
     *  failed to lazily initialize a collection of role: com.example.osiv.Member.teams, could not initialize proxy - no Session
     * */
    @GetMapping("team/{id}")
    public Set<Team> getTeam(@PathVariable Long id) {
        System.out.println("********************Controller********************");
        Set<Team> teams = teamService.getTeam(id);

//        for (Team team : teams) {
//            team.setName("change name");
//            String name = team.getName();
//            System.out.println("name = " + name);
//        }
//        entityManager.flush();
        System.out.println("********************Controller********************");

        return teams;
    }

}
