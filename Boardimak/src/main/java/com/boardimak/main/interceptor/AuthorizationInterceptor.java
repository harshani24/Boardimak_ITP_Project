package com.boardimak.main.interceptor;

import com.boardimak.main.UserPrincipal;
import com.boardimak.main.authorization.AuthorizationService;
import com.boardimak.main.authorization.HandlerValidator;
import com.boardimak.main.model.User;
import com.boardimak.main.repository.UsersRepository;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private HandlerValidator handlerValidator;

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	
        HandlerMethod handlerMethod = handlerValidator.getValidHandler(handler);

        // need to pass the logged in user's id
        User loggedInUser = usersRepository.findByEmail(request.getUserPrincipal().getName());
        System.out.println("User ID: " + request.getUserPrincipal().getName());

        return authorizationService.isAuthorized(handlerMethod, loggedInUser.getUserType());
    }
}
