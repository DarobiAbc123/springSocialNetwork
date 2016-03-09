package de.gertuts4pc.springsocial.service;

import de.gertuts4pc.springsocial.dao.UserDAO;
import de.gertuts4pc.springsocial.form.LoginForm;
import de.gertuts4pc.springsocial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginSerive {

    @Autowired private UserDAO userDAO;

    public boolean login(HttpServletRequest request, LoginForm login) throws NoSuchAlgorithmException {
        String password = new String(MessageDigest.getInstance("MD5").digest(login.getPassword().getBytes()));
        if(!userDAO.userWithCredentialsExists(login.getUsername(), password)) {
            return false;
        }
        User user = userDAO.getUserByCredentials(login.getUsername(), password);
        request.getSession().setAttribute("session", user);
        return true;
    }

}
