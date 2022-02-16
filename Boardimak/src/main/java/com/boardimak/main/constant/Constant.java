package com.boardimak.main.constant;

public class Constant {

    public static class USER_ROLES {

        public static final String STUDENT = "Student";
        public static final String PARENT = "Parent";
        public static final String OWNER = "Owner";
        public static final String EMPLOYEE = "Employee";
        public static final String ADMIN = "Admin";
    }

    public static class AUTH_API_PATTERNS {

        public static final String DUMMIES = "/dummies/**"; //dummies/anything (wild card characters)
        public static final String USERS = "/users/**";
        public static final String TICKET = "/ticket/**";
//        public static final String EDIT_USERS = "/editUser?**";
    }
}
