package com.example.back_end.dto.Resource;


import com.example.back_end.Entity.Resource.ResourcePriceInfoIdTb;
import com.example.back_end.Entity.Resource.ResourcePriceInfoTb;
import com.example.back_end.Entity.Resource.ResourceTb;
import com.example.back_end.Entity.Unit.UnitTb;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonAutoDetect
@Getter
@NoArgsConstructor
public class ResourcePriceInfoTbSaveDto {

    private String resourceDatePk;
    private float price;
    private String resourceTbSymbol;
    private String unitIdName;

    @Builder
    public ResourcePriceInfoTbSaveDto(String resourceDatePk,
                                      Float price,
                                      String resourceTbSymbol,
                                      String unitIdName){
        this.resourceDatePk = resourceDatePk;
        this.price = price;
        this.resourceTbSymbol = resourceTbSymbol;
        this.unitIdName = unitIdName;
    }

    public ResourcePriceInfoTb toEntity(ResourcePriceInfoIdTb resourcePriceInfoIdTb,
                                        ResourceTb resourceIdMk,
                                        UnitTb unitIdFk
                                           ){
        return ResourcePriceInfoTb.builder()
                .resourcePriceInfoIdTb(resourcePriceInfoIdTb)
                .price(price)
                .resourceIdMk(resourceIdMk)
                .unitIdFk(unitIdFk)
                .build();
    }


}
