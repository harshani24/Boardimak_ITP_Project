package com.boardimak.main.authorization;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

@Component
public class HandlerValidator {

    public HandlerMethod getValidHandler(Object handler) {

        if (handler instanceof HandlerMethod) {

            HandlerMethod handlerMethod = (HandlerMethod) handler;

//            if (!handlerMethod.getMethod().getDeclaringClass().isAnnotationPresent(RestController.class)) {
//                throw new UnsupportedOperationException();
//            }
            return handlerMethod;
        }
        throw new UnsupportedOperationException();
    }
}
