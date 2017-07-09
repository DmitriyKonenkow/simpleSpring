package ru.spb.konenkow.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class SimpleRestController {

    @GetMapping("/hello")
    public @ResponseBody
    String getText() {
        return "Hello world";
    }


}
