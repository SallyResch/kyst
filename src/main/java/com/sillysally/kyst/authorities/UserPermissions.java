package com.sillysally.kyst.authorities;

public enum UserPermissions {
    ADMIN_READ ("admin:read"),
    ADMIN_WRITE ("admin:post"),
    ADMIN_DELETE ("admin:delete"),

    MODERATOR_READ ("moderator:read"),
    MODERATOR_WRITE("moderator:write"),

    USER_READ("user:read"),
    USER_POST("user:post");

    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
