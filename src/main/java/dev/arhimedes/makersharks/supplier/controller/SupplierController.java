package dev.arhimedes.makersharks.supplier.controller;

import dev.arhimedes.makersharks.helper.api.APIResponse;
import dev.arhimedes.makersharks.supplier.dto.SupplierDTO;
import dev.arhimedes.makersharks.supplier.dto.SupplierQuery;
import dev.arhimedes.makersharks.supplier.entity.Supplier;
import dev.arhimedes.makersharks.supplier.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;


    @PostMapping
    public ResponseEntity<APIResponse<SupplierDTO>> create(@RequestBody @Valid SupplierDTO record) {
        Supplier supplier = supplierService.create(record);

        return new ResponseEntity<>(
                APIResponse.withBody(
                        "Supplier Record Saved",
                        new SupplierDTO(
                                supplier.getId(), supplier.getCompany(), supplier.getWebsite(), supplier.getLocation(), supplier.getNature().name(), supplier.getProcess().name()
                        )
                ),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/query")
    public ResponseEntity<APIResponse<List<SupplierDTO>>> getByQuery(@RequestBody @Valid SupplierQuery query) {
        List<SupplierDTO> records = supplierService.fetchByQuery(query);

        return new ResponseEntity<>(
                APIResponse.withBody(
                        "Records Fetched",
                        records
                ),
                HttpStatus.OK
        );
    }

}
