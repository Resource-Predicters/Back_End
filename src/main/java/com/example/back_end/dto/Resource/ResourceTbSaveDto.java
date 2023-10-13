package com.example.back_end.dto.Resource;

import com.example.back_end.Entity.Resource.ResourceTb;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResourceTbSaveDto {
    private String resourceEngName;
    private String resourceKorName;
    private String resourceSymbol;

    @Builder
    public ResourceTbSaveDto(String resourceEngName,
                             String resourceKorName,
                             String resourceSymbol
                             ){
        this.resourceEngName = resourceEngName;
        this.resourceKorName = resourceKorName;
        this.resourceSymbol = resourceSymbol;
    }

    public ResourceTb toEntity(){
        return ResourceTb.builder()
                .resourceEngName(resourceEngName)
                .resourceKorName(resourceKorName)
                .resourceSymbol(resourceSymbol)
                .build();
    }



}
