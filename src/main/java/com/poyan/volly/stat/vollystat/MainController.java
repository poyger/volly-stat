package com.poyan.volly.stat.vollystat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poyan.volly.stat.vollystat.model.GameResult;
import com.poyan.volly.stat.vollystat.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ResourceUtils.CLASSPATH_URL_PREFIX;

@Controller
public class MainController {

    private MainRepository mainRepository;

    @Autowired
    public MainController(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @RequestMapping("/getPlayers")
    @ResponseBody
    @SuppressWarnings("unused")
    public List<Player> getPlayers() {
        return mainRepository.getAllPlayers();
    }

    @RequestMapping(value = "/submitGameResult", method = RequestMethod.POST)
    @SuppressWarnings("unused")
    public String submitGameResult(@RequestBody GameResult gameResult) {
        mainRepository.submitResult(gameResult);
        return "redirect:results.html";
    }

    @RequestMapping(value = "/getResults")
    @ResponseBody
    @SuppressWarnings("unused")
    public List<GameResult> getResult() throws IOException {
        List<GameResult> results = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        File resultFolder = ResourceUtils.getFile(CLASSPATH_URL_PREFIX + "results");
        File[] resultFiles = resultFolder.listFiles();
        for (File resultFile : resultFiles) {
            GameResult gameResult = mapper.readValue(resultFile, GameResult.class);
            results.add(gameResult);
        }
        return results;

    }
}