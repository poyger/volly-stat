package com.poyan.volly.stat.vollystat;

import com.poyan.volly.stat.vollystat.model.GameResult;
import com.poyan.volly.stat.vollystat.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    private MainRepository mainRepository;

    @Autowired
    public MainController(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

/*
    @RequestMapping("/")
    public String start() {
        return "start";
    }
*/

    @RequestMapping("/getPlayers")
    @ResponseBody
    public List<Player> getPlayers() {
        return mainRepository.getAllPlayers();
    }

    @RequestMapping(value = "/submitGameResult", method = RequestMethod.POST)
    public String submitGameResult(@RequestBody GameResult gameResult) {
        System.out.println(gameResult);
        return "start";
    }
}