package de.gertuts4pc.springsocial.service;

import de.gertuts4pc.springsocial.dao.UserDAO;
import de.gertuts4pc.springsocial.form.RegisterForm;
import de.gertuts4pc.springsocial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class RegisterService {

    @Autowired private UserDAO userDAO;

    public boolean register(HttpServletRequest request, RegisterForm registerForm) throws NoSuchAlgorithmException {
        if(!registerForm.getPassword().equals(registerForm.getPasswordRepeat())) {
            return false;
        }
        if(userDAO.usernameExists(registerForm.getUsername())) {
            return false;
        }
        if(userDAO.emailExists(registerForm.getEmail())) {
            return false;
        }
        User user = new User();
        user.setUsername(registerForm.getUsername());
        user.setEMailAddress(registerForm.getEmail());
        user.setPassword(new String(MessageDigest.getInstance("MD5").digest(registerForm.getPassword().getBytes())));
        userDAO.save(user);
        request.getSession().setAttribute("session", user);
        return true;
    }

}
