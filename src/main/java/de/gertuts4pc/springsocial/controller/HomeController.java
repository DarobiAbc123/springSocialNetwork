package de.gertuts4pc.springsocial.controller;

import de.gertuts4pc.springsocial.annotation.RequiredLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/home")
@RequiredLogin
@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }

}
