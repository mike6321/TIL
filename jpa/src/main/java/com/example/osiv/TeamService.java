package com.example.osiv;

import com.example.osiv.dto.TeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createTeam(TeamRequest teamRequest) {
        Long id = teamRequest.getId();
        Member member = memberRepository.findById(id)
                .orElseThrow();

        Set<Team> teams = teamRequest.getTeams()
                .stream()
                .map(Team::of)
                .collect(Collectors.toSet());

        member.createTeam(teams);
    }

}
