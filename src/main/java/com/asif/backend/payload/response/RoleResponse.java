package com.asif.backend.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleResponse {
    private Long id;
    private String roleName;
    private Set<UserResponseDto> users;
}
