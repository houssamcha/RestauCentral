package com.RestauCentral.RestauCentral.Model.Enum;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    USER,
    RESTAURANT,
    ;

    @Override
    public String getAuthority() {
        return this.name();
    }

}
