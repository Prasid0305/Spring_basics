package com.example.team_gradle;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Hello")
public class HelloController {

    @GetMapping("message1")
    public String sayHello(){
        return "hello !!\n this is HelloController class.....";

    }
    @GetMapping("message2/{name}")
    public String sayMessage(@PathVariable String name){
        return  name +" have completed the basic setup";
    }

    @PostMapping("/echo")
    public String echo(@RequestBody String data) {
        return "You sent: " + data;
    }

    @PostMapping("data")
    public String data(@RequestBody Map<Integer, String> infoData){


        return "the data is" +infoData;


    }


}
