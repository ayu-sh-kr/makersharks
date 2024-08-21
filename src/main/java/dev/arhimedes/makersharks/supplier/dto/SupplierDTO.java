package dev.arhimedes.makersharks.supplier.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.arhimedes.makersharks.supplier.enums.BusinessNature;
import dev.arhimedes.makersharks.supplier.enums.ManufacturingProcess;
import dev.arhimedes.makersharks.supplier.utils.validators.annotations.EnumPattern;
import jakarta.validation.constraints.NotBlank;

public record SupplierDTO(

    Integer id,

    @NotBlank(message = "Company name can't be blank")
    @JsonProperty("company_name")
    String company,

    @NotBlank(message = "Website can't be blank")
    String website,

    @NotBlank(message = "Location can't be blank")
    String location,

    @NotBlank(message = "Nature can't be blank")
    @EnumPattern(enumClass = BusinessNature.class)
    @JsonProperty("business_nature")
    String nature,

    @NotBlank(message = "Process can't be blank")
    @EnumPattern(enumClass = ManufacturingProcess.class)
    @JsonProperty("manufacturing_process")
    String process
) {
    public SupplierDTO(Integer id, String company, String website, String location, BusinessNature nature, ManufacturingProcess process) {
        this(id, company, website, location, nature.name(), process.name());
    }

}
