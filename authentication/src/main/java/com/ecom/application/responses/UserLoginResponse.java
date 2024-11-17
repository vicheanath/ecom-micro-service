package com.ecom.application.responses;

import lombok.Data;

@Data
public class UserLoginResponse {
   private String token;
   private String username;

    public UserLoginResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }
}
