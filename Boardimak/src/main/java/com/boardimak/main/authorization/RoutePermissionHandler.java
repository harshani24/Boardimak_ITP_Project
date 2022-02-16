package com.boardimak.main.authorization;

import com.boardimak.main.annotation.RequiresPermission;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

@Component
public class RoutePermissionHandler {

    String getPermission(final HandlerMethod handlerMethod) {

        String permission = "";
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(RequiresPermission.class)) {

            RequiresPermission requestPermission = method.getAnnotation(RequiresPermission.class);
            permission = requestPermission.permission();
        }
        return permission;
    }
}
