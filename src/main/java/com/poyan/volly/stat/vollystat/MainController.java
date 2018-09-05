package com.poyan.volly.stat.vollystat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/")
    public String start() {
        return "start";
    }

    @RequestMapping("/getPlayers")
    @ResponseBody
    public String getPlayers() {
        return "  [{\n" +
                "    \"id\": \"1\",\n" +
                "    \"name\": \"Poyan\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"2\",\n" +
                "    \"name\": \"Peyman\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"3\",\n" +
                "    \"name\": \"Mohsen\"\n" +
                "  }\n" +
                "]";
    }
}
