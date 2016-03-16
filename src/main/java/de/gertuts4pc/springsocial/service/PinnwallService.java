package de.gertuts4pc.springsocial.service;

import de.gertuts4pc.springsocial.dao.PinnwallDAO;
import de.gertuts4pc.springsocial.dao.UserDAO;
import de.gertuts4pc.springsocial.model.Followable;
import de.gertuts4pc.springsocial.model.PinnwallEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Service
public class PinnwallService {

    @Autowired private PinnwallDAO pinnwallDAO;
    @Autowired private UserDAO userDAO;

    public void postData(String post, Long id, HttpServletRequest request) {
        Object session = request.getSession().getAttribute("session");
        if(session == null) {
            return;
        }
        if(!id.equals(((Followable)session).getId())) {
            return;
        }
        PinnwallEntry pinnwallEntry = new PinnwallEntry();
        pinnwallEntry.setText(post);
        pinnwallEntry.setAuthor(userDAO.getByID(id));
        pinnwallEntry.setPostOn(Calendar.getInstance());
        pinnwallDAO.save(pinnwallEntry);
    }

}
