package com.finwise.FinWise.dto;

import com.finwise.FinWise.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String username;
    private String email;
    private String password;
    private Role role;


}
