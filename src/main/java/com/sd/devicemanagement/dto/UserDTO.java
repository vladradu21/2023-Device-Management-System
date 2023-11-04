package com.sd.devicemanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @Size(min = 3, max = 20)
        @NotNull
        String username
) {
}
