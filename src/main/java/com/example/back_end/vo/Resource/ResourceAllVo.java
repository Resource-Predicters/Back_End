package com.example.back_end.vo.Resource;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ResourceAllVo {
    private LocalDate date;
    private Float price;
    private String korName;
    private String engName;
    private String Symbol;
    private String unit;
}
