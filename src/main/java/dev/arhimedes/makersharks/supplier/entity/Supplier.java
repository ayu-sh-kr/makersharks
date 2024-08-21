package dev.arhimedes.makersharks.supplier.entity;

import dev.arhimedes.makersharks.supplier.enums.BusinessNature;
import dev.arhimedes.makersharks.supplier.enums.ManufacturingProcess;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String company;
    private String website;
    private String location;

    @Enumerated(EnumType.STRING)
    private BusinessNature nature;

    @Enumerated(EnumType.STRING)
    private ManufacturingProcess process;

}
