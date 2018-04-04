package hls.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by hossiel on 16/06/2016.
 */
@Controller
// @RequestMapping("/test")
@RequestMapping("/")
public class TestController{
    @RequestMapping(method = RequestMethod.GET)
    public String gotoHometest() {
        return "home";
    }
    }