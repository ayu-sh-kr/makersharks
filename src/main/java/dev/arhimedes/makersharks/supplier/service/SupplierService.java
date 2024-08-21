package dev.arhimedes.makersharks.supplier.service;

import dev.arhimedes.makersharks.supplier.dto.SupplierQuery;
import dev.arhimedes.makersharks.supplier.repository.SupplierRepository;
import dev.arhimedes.makersharks.supplier.dto.SupplierDTO;
import dev.arhimedes.makersharks.supplier.entity.Supplier;
import dev.arhimedes.makersharks.supplier.enums.BusinessNature;
import dev.arhimedes.makersharks.supplier.enums.ManufacturingProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;


    public Supplier create(SupplierDTO record) {
        Supplier supplier = Supplier.builder()
                .company(record.company())
                .location(record.location())
                .website(record.website())
                .nature(BusinessNature.valueOf(record.nature()))
                .process(ManufacturingProcess.valueOf(record.process()))
                .build();

        supplier = supplierRepository.save(supplier);

        return supplier;
    }

    public List<SupplierDTO> fetchByQuery(SupplierQuery query) {
        return supplierRepository.findByLocationAndNatureAndProcess(
                query.location(), BusinessNature.valueOf(query.nature()),
                ManufacturingProcess.valueOf(query.process()), Limit.of(query.count())
        );
    }
}
