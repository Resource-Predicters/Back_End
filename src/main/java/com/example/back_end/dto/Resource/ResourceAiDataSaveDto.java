package com.example.back_end.dto.Resource;


import com.example.back_end.Entity.Resource.*;
import com.example.back_end.Entity.Unit.UnitTb;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@JsonAutoDetect
@Getter
@NoArgsConstructor
public class ResourceAiDataSaveDto {

    private String resourceAiDatePk;
    private float price;
    private String resourceTbSymbol;

    @Builder
    public ResourceAiDataSaveDto(String resourceAiDatePk,
                                 Float price,
                                 String resourceTbSymbol
                                 ){
        this.resourceAiDatePk = resourceAiDatePk;
        this.price = price;
        this.resourceTbSymbol = resourceTbSymbol;
    }

    public ResourceAiDataTb toEntity(ResourceAiDataIdTb resourceAiDataIdTb,
                                     ResourceTb resourceIdMk,
                                     float price
    ){
        return ResourceAiDataTb.builder()
                .resourceAiDataIdTb(resourceAiDataIdTb)
                .price(price)
                .resourceIdMk(resourceIdMk)
                .build();
    }

}
