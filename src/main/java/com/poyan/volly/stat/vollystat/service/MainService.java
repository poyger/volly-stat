package com.poyan.volly.stat.vollystat.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poyan.volly.stat.vollystat.model.GameResult;
import com.poyan.volly.stat.vollystat.model.Player;
import com.poyan.volly.stat.vollystat.model.PlayerStanding;
import com.poyan.volly.stat.vollystat.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MainService {
    private final ResourcePatternResolver resourcePatternResolver;

    @Autowired
    public MainService(ResourcePatternResolver resourcePatternResolver) {
        this.resourcePatternResolver = resourcePatternResolver;
    }

    public List<GameResult> getGameResult() throws IOException {
        List<GameResult> results = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        org.springframework.core.io.Resource[] resources = resourcePatternResolver.getResources("classpath:results/*.json");
        for (Resource resource : resources) {
            GameResult gameResult = mapper.readValue(resource.getInputStream(), GameResult.class);
            results.add(gameResult);
        }
        return results;
    }


    public List<PlayerStanding> getStanding() throws IOException {
        Map<Player, PlayerStanding> standing = new HashMap<>();
        List<GameResult> result = getGameResult();

        for (GameResult gameResult : result) {
            int team1SetWin = gameResult.getTeam1SetWin();
            int team2SetWin = gameResult.getTeam2SetWin();
            updateStanding(standing, gameResult.getTeam1(), team1SetWin, team2SetWin);
            updateStanding(standing, gameResult.getTeam2(), team2SetWin, team1SetWin);
        }

        return standing.keySet().stream()
                .map(player -> standing.get(player))
                .sorted((o1, o2) -> {
                    int pointsCompare = Integer.compare(o2.getPoints(), o1.getPoints());
                    if (pointsCompare == 0) {
                        return Integer.compare(o2.getSetDifference(), o1.getSetDifference());
                    } else {
                        return pointsCompare;
                    }
                })
                .collect(Collectors.toList());
    }

    private void updateStanding(Map<Player, PlayerStanding> standing, Team team, int setWin, int setLose) {
        for (Player player : team.getPlayers()) {
            PlayerStanding playerStanding = standing.computeIfAbsent(player, key -> new PlayerStanding(key));
            playerStanding.incPlayedGames(1);
            playerStanding.incSetWin(setWin);
            playerStanding.incSetLose(setLose);
            playerStanding.incWin(setWin > setLose ? 1 : 0);
            playerStanding.incLose(setLose > setWin ? 1 : 0);
            playerStanding.incPoints(setWin > setLose ? 3 : 0);
            playerStanding.incPoints(setWin);
        }
    }
}
