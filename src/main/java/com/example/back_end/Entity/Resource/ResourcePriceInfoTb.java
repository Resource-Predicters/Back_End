package com.example.back_end.Entity.Resource;


import com.example.back_end.Entity.Unit.UnitTb;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class ResourcePriceInfoTb {
    @EmbeddedId
    private ResourcePriceInfoIdTb resourcePriceInfoIdTb;

    @MapsId("resourceIdMk")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ResourceIdMk")
    private ResourceTb resourceIdMk;

    @NotNull
    private float price;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UnitTbPk")
    private UnitTb unitIdFk;

    @Builder
    public ResourcePriceInfoTb(ResourcePriceInfoIdTb resourcePriceInfoIdTb,
                               ResourceTb resourceIdMk,
                               float price,
                               UnitTb unitIdFk) {
        this.resourcePriceInfoIdTb = resourcePriceInfoIdTb;
        this.resourceIdMk = resourceIdMk;
        this.price = price;
        this.unitIdFk = unitIdFk;
    }


}
