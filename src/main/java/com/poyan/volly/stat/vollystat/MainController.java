package com.poyan.volly.stat.vollystat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poyan.volly.stat.vollystat.model.GameResult;
import com.poyan.volly.stat.vollystat.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class MainController {

    private final ResourcePatternResolver resourcePatternResolver;
    private MainRepository mainRepository;

    @Autowired
    public MainController(MainRepository mainRepository, ResourcePatternResolver resourcePatternResolver) {
        this.mainRepository = mainRepository;
        this.resourcePatternResolver = resourcePatternResolver;
    }

    @RequestMapping("/getPlayers")
    @ResponseBody
    @SuppressWarnings("unused")
    public List<Player> getPlayers() {
        return mainRepository.getAllPlayers();
    }



    @RequestMapping(value = "/getResults")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    @SuppressWarnings("unused")
    public List<GameResult> getResult() throws IOException {
        List<GameResult> results = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        org.springframework.core.io.Resource[] resources = resourcePatternResolver.getResources("classpath:results/*.json");
        int id = 0;
        for (Resource resource : resources) {
            GameResult gameResult = mapper.readValue(resource.getInputStream(), GameResult.class);
            gameResult.getTeam1().getPlayers().sort(Comparator.comparing(Player::getName));
            gameResult.getTeam2().getPlayers().sort(Comparator.comparing(Player::getName));
            generateId(id, gameResult);
            results.add(gameResult);
            id++;
        }
        results.sort((o1, o2) -> o2.getGame().getDate().compareTo(o1.getGame().getDate()));
        return results;
    }

    private void generateId(int id, GameResult gameResult) {
        gameResult.setId(id);
    }
}