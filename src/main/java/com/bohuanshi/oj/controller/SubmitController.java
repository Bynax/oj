package com.bohuanshi.oj.controller;



import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class SubmitController {

    @RequestMapping(value="/submit", method = RequestMethod.POST)
    public String index(@RequestBody Map<String,Object>paras){
        String a = paras.get("hello").toString();
        String b = paras.get("code").toString();
        return String.format("%s\t%s",a,b);

    }

}
