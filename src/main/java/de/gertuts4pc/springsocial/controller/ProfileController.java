package de.gertuts4pc.springsocial.controller;

import de.gertuts4pc.springsocial.annotation.RequiredLogin;
import de.gertuts4pc.springsocial.dao.PinnwallDAO;
import de.gertuts4pc.springsocial.dao.UserDAO;
import de.gertuts4pc.springsocial.model.User;
import de.gertuts4pc.springsocial.service.PinnwallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredLogin
@RequestMapping("/profil")
public class ProfileController {

    @Autowired private PinnwallService pinnwallService;
    @Autowired private UserDAO userDAO;
    @Autowired private PinnwallDAO pinnwallDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getProfil(@PathVariable Long id, ModelMap modelMap) {
        User user = userDAO.getByID(id);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("pinnwall", pinnwallDAO.getSortedEntriesForFollowable(user));
        return "profile/userProfile";
    }

    @RequestMapping(value = "/{id}/addPost", method = RequestMethod.POST)
    public String addPost(@PathVariable Long id, @RequestParam("posting") String post, HttpServletRequest request) {
        pinnwallService.postData(post, id, request);
        return "redirect:/profil/" + String.valueOf(id);
    }

}
