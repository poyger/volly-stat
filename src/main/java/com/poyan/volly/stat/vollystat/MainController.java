package com.poyan.volly.stat.vollystat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    private MainRepository mainRepository;

    @Autowired
    public MainController(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @RequestMapping("/")
    public String start() {
        return "start";
    }

    @RequestMapping("/getPlayers")
    @ResponseBody
    public List<Player> getPlayers() {
        return mainRepository.getAllPlayers();
    }
}