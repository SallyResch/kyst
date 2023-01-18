package com.sillysally.kyst.authorities;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import static com.sillysally.kyst.authorities.UserPermissions.*;
public enum UserRoles {
    USER(List.of(USER_READ, USER_POST)),
    MODERATOR(List.of(MODERATOR_READ, MODERATOR_WRITE)),
    ADMIN(List.of(ADMIN_READ, ADMIN_WRITE, ADMIN_DELETE));

    private final List<UserPermissions> permissionsList;

    UserRoles(List<UserPermissions> permissions) {
        this.permissionsList = permissions;
    }

    public List<UserPermissions> getPermissionsList() {
        return permissionsList;
    }
    //For loop with Streams
    public List<SimpleGrantedAuthority> getGrantedAuthorities () {
        List<SimpleGrantedAuthority> permissions = new ArrayList<>(getPermissionsList().stream().map(
                index -> new SimpleGrantedAuthority(index.getPermission())
        ).toList());
        //when finished: Add role (example ROLE_ADMIN)
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
}
