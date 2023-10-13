package com.example.back_end.Entity.Resource;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class ResourcePriceInfoIdTb implements Serializable {

    @Column(name = "resource_date_pk", nullable = false)
    private LocalDate resourceDatePk;

    @Column(name = "resource_id_mk", nullable = false)
    private int resourceIdMk;

    @Builder
    public ResourcePriceInfoIdTb(LocalDate resourceDatePk, int resourceIdMk) {
        this.resourceDatePk = resourceDatePk;
        this.resourceIdMk = resourceIdMk;
    }

}

