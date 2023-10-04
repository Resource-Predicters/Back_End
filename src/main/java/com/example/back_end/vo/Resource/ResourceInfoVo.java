package com.example.back_end.vo.Resource;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
@Builder
public class ResourceInfoVo {
    private LocalDate date;
    private Float price;
    private String korName;
    private String engName;
    private String Symbol;
    private String unit;

}
