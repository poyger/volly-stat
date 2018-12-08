package com.poyan.volly.stat.vollystat.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poyan.volly.stat.vollystat.model.GameResult;
import com.poyan.volly.stat.vollystat.model.Player;
import com.poyan.volly.stat.vollystat.model.PlayerStanding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

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

            for (Player player : gameResult.getTeam1().getPlayers()) {
                PlayerStanding playerStanding = standing.computeIfAbsent(player, key -> new PlayerStanding(key));
                playerStanding.incPlayedGames(1);
                playerStanding.incSetWin(team1SetWin);
                playerStanding.incSetLose(team2SetWin);
                playerStanding.incWin(team1SetWin > team2SetWin ? 1 : 0);
                playerStanding.incLose(team1SetWin < team2SetWin ? 1 : 0);
                playerStanding.incPoints(team1SetWin > team2SetWin ? 3 : 0);
                playerStanding.incPoints(team1SetWin);
            }

            for (Player player : gameResult.getTeam2().getPlayers()) {
                PlayerStanding playerStanding = standing.computeIfAbsent(player, key -> new PlayerStanding(key));
                playerStanding.incPlayedGames(1);
                playerStanding.incSetWin(team2SetWin);
                playerStanding.incSetLose(team1SetWin);
                playerStanding.incLose(team1SetWin > team2SetWin ? 1 : 0);
                playerStanding.incWin(team1SetWin < team2SetWin ? 1 : 0);
                playerStanding.incPoints(team2SetWin > team1SetWin ? 3 : 0);
                playerStanding.incPoints(team2SetWin);
            }
        }
        return standing.keySet().stream()
                .map(player -> standing.get(player))
                .sorted((o1, o2) -> Integer.compare(o2.getPoints(), o1.getPoints()))
                .collect(Collectors.toList());
    }
}
