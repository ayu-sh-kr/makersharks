package dev.arhimedes.makersharks.supplier.repository;

import dev.arhimedes.makersharks.supplier.dto.SupplierDTO;
import dev.arhimedes.makersharks.supplier.entity.Supplier;
import dev.arhimedes.makersharks.supplier.enums.BusinessNature;
import dev.arhimedes.makersharks.supplier.enums.ManufacturingProcess;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {


    List<SupplierDTO> findByLocationAndNatureAndProcess(String location, BusinessNature nature, ManufacturingProcess process, Limit limit);
}
