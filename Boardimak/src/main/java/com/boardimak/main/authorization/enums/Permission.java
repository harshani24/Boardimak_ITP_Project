package com.boardimak.main.authorization.enums;

import com.boardimak.main.constant.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Permission {

    public enum Student {
        ACCESS_DUMMY,
        TICKET
    }

    public enum Parent {
        ACCESS_DUMMY,
        TICKET
    }

    public enum Owner {
        ACCESS_DUMMY,
        TICKET
    }

    public enum Employee {
        ACCESS_DUMMY,
        TICKET
    }

    public enum Admin {
        ACCESS_DUMMY,
        USERS,
        TICKET
    }

    public static Map<String, List<String>> getPermissions() {

        Map<String, List<String>> permissionMap = new HashMap<>();
        permissionMap.put(Constant.USER_ROLES.ADMIN, Stream.of(Admin.values())
                .map(Admin::name)
                .collect(Collectors.toList()));

        permissionMap.put(Constant.USER_ROLES.EMPLOYEE, Stream.of(Employee.values())
                .map(Employee::name)
                .collect(Collectors.toList()));

        permissionMap.put(Constant.USER_ROLES.OWNER, Stream.of(Owner.values())
                .map(Owner::name)
                .collect(Collectors.toList()));

        permissionMap.put(Constant.USER_ROLES.PARENT, Stream.of(Parent.values())
                .map(Parent::name)
                .collect(Collectors.toList()));

        permissionMap.put(Constant.USER_ROLES.STUDENT, Stream.of(Student.values())
                .map(Student::name)
                .collect(Collectors.toList()));

        return permissionMap;
    }
}
