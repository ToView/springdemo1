package com.rocky.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rocky on 17-7-26.
 */
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public Map<String,Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "success");
        map.put("msg", "HelloWorld");
        return map;
    }


}
