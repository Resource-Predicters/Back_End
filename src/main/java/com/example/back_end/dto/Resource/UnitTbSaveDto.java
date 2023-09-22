package com.example.back_end.dto.Resource;

import com.example.back_end.Entity.UnitTb;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UnitTbSaveDto {
    private String unitName;

    @Builder
    public UnitTbSaveDto(String unitName)
    {
        this.unitName = unitName;
    }

    public UnitTb toEntity()
    {
        return UnitTb.builder()
                .unitName(unitName)
                .build();
    }
}
