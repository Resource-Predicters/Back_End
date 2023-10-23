package com.example.back_end.Entity.Resource;

import com.example.back_end.Entity.Unit.UnitTb;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class ResourceAiDataTb {

    @EmbeddedId
    private ResourceAiDataIdTb resourceAiDataIdTb;

    @MapsId("resourceAiIdMk")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_ai_id_mk")
    private ResourceTb resourceIdMk;

    @NotNull
    private float price;

    @Builder
    public ResourceAiDataTb(ResourceAiDataIdTb resourceAiDataIdTb,
                            ResourceTb resourceIdMk,
                            float price) {
        this.resourceAiDataIdTb = resourceAiDataIdTb;
        this.resourceIdMk = resourceIdMk;
        this.price = price;
    }
}
