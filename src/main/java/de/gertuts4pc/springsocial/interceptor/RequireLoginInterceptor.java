package de.gertuts4pc.springsocial.interceptor;

import de.gertuts4pc.springsocial.annotation.RequiredLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequireLoginInterceptor implements HandlerInterceptor {

    @Autowired private ServletContext servletContext;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        if(request.getSession().getAttribute("session") == null && ((HandlerMethod) handler).getBean().getClass().isAnnotationPresent(RequiredLogin.class)) {
            response.sendRedirect(servletContext.getContextPath() + "/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
