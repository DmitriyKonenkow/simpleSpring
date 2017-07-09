package ru.spb.konenkow.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class SimpleRestController {

    @GetMapping("/hello")
    public @ResponseBody
    String getHello(@RequestParam String name) {
        return "Hello " + name;
    }


}
