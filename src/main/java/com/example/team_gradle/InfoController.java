package com.example.team_gradle;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("info")
public class InfoController {
    Map<Integer, String> info = new HashMap<>();
    public void  infoControllerData() {
        info.put(101, "Prasid");
        info.put(102, "Gracia");
        info.put(103, "Pedri");
    }


    @GetMapping("/getinfo")
    public Map<Integer, String> getInfo(){
        return info;
    }

    @PostMapping("/postInfo")
    public String addInfo(@RequestParam int id, @RequestParam String name) {
        info.put(id, name);
        return "Added: " + id + " -> " + name;
    }

    @Value("${app.name}")
    private String appName;

    @GetMapping("/configName")
    public String getAppName(){
        return "appName: "+appName;
    }


}
