package com.asif.backend.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @Schema(example = "Rezwan")
    private String name;

    @Schema(example = "rezwan")
    private String username;

    @Schema(example = "rezwan@tn.com")
    private String email;

    @Schema(example = "1234")
    private String password;
}
