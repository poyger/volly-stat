package com.poyan.volly.stat.vollystat;

import com.poyan.volly.stat.vollystat.model.GameResult;
import com.poyan.volly.stat.vollystat.model.PlayerStanding;
import com.poyan.volly.stat.vollystat.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping(value = "/getResults")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    @SuppressWarnings("unused")
    public List<GameResult> getResult() throws IOException {
        List<GameResult> result = mainService.getGameResult();
        List<GameResult> sortedResult = result.stream()
                .sorted((o1, o2) -> o2.getGame().getDate().compareTo(o1.getGame().getDate()))
                .peek(gameResult -> gameResult.getTeam1().getPlayers().sort(Comparator.comparing(player -> player.getName())))
                .peek(gameResult -> gameResult.getTeam2().getPlayers().sort(Comparator.comparing(player -> player.getName())))
                .collect(Collectors.toList());
        return sortedResult;
    }

    @RequestMapping(value = "/getStanding")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    @SuppressWarnings("unused")
    public List<PlayerStanding> getStanding() throws IOException {
        return mainService.getStanding();
    }

}