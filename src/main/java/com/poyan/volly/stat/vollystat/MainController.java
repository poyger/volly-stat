package com.poyan.volly.stat.vollystat;

import com.poyan.volly.stat.vollystat.model.GameResult;
import com.poyan.volly.stat.vollystat.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @RequestMapping(value = "/result")
    @ResponseBody
    @SuppressWarnings("unused")
    public ModelAndView getResult(ModelMap model) {
        model.addAttribute("POYAN");
        return new ModelAndView("forward:/results.html", model);
    }
}