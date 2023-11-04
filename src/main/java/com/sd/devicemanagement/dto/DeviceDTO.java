package com.sd.devicemanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DeviceDTO(
        @Size(min = 3, max = 20)
        @NotNull
        String name,

        @NotNull
        String description,

        @NotNull
        String address,

        @NotNull
        double maxConsumption
) {
}
