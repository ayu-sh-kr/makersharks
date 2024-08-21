package dev.arhimedes.makersharks.supplier.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.arhimedes.makersharks.supplier.enums.BusinessNature;
import dev.arhimedes.makersharks.supplier.enums.ManufacturingProcess;
import dev.arhimedes.makersharks.supplier.utils.validators.annotations.EnumPattern;
import jakarta.validation.constraints.NotBlank;

public record SupplierQuery(
        Integer count,

        @NotBlank(message = "Location can't be blank")
        String location,

        @JsonProperty("business_nature")
        @EnumPattern(enumClass = BusinessNature.class)
        String nature,

        @JsonProperty("manufacturing_process")
        @EnumPattern(enumClass = ManufacturingProcess.class)
        String process
) {
}
