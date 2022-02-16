package com.boardimak.main.authorization;

import com.boardimak.main.authorization.enums.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.HandlerMethod;

@Service
@Scope("singleton")
public class AuthorizationService {

    @Autowired
    private RoutePermissionHandler routePermissionHandler;

    public boolean isAuthorized(final HandlerMethod handlerMethod, final String role) {

        if (handlerMethod.getBean() instanceof  Authorizable) {

            String permission = routePermissionHandler.getPermission(handlerMethod);

            if (!this.checkPermissions(permission, role)) {

                throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "You do not have permission");
            }
        }
        return true;
    }

    private boolean checkPermissions(final String permission, final String role) {

        return Permission.getPermissions().get(role).contains(permission);
    }
}
