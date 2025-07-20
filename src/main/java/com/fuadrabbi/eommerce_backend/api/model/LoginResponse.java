package com.fuadrabbi.eommerce_backend.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String jwt;
    private boolean success;
    private String failureReason;

    public boolean isSuccess() {
        return success;
    }
}
