package de.gertuts4pc.springsocial.controller;

import de.gertuts4pc.springsocial.form.LoginForm;
import de.gertuts4pc.springsocial.form.RegisterForm;
import de.gertuts4pc.springsocial.service.LoginSerive;
import de.gertuts4pc.springsocial.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@Controller
public class UserController {

    @Autowired private LoginSerive loginSerive;
    @Autowired private RegisterService registerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(ModelMap modelMap) {
        modelMap.addAttribute("login", new LoginForm());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLoginPage(@ModelAttribute(value = "login") LoginForm loginForm, HttpServletRequest request) throws NoSuchAlgorithmException {
        if(loginSerive.login(request, loginForm)) {
            return "redirect:/home";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(ModelMap modelMap) {
        modelMap.addAttribute("register", new RegisterForm());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegisterPage(@ModelAttribute(value = "register") RegisterForm registerForm, HttpServletRequest request) throws NoSuchAlgorithmException {
        if(registerService.register(request, registerForm)) {
            return "redirect:/home";
        }
        return "redirect:/register";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("session");
        return "redirect:/login";
    }

}
