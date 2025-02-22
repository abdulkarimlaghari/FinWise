package com.finwise.FinWise.dto;

import com.finwise.FinWise.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor  // Generates a default no-args constructor (needed for serialization)
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private Role role;
}
