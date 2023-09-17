package com.asif.backend.payload.request;

import com.asif.backend.generic.payload.request.IDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuPermissionDto implements IDto {
    @NotNull
    @Schema(example = "1")
    private Long roleId;

    @Schema(example = "[1,2,3]")
    private Set<Long> menuIds;
}
