package com.example.back_end.Entity.Resource;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;


@Embeddable
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class ResourceAiDataIdTb implements Serializable {

    @Column(name = "resource_ai_date_id_pk", nullable = false)
    private LocalDate resourceAiDataIdTb;

    @Column(name = "resource_ai_id_mk", nullable = false)
    private int resourceAiIdMk;

    @Builder
    public ResourceAiDataIdTb(LocalDate resourceAiDataIdTb, int resourceAiIdMk) {
        this.resourceAiDataIdTb = resourceAiDataIdTb;
        this.resourceAiIdMk = resourceAiIdMk;
    }

}

