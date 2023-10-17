package com.example.back_end.vo.Resource;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Builder
public class ResourceVo {
    private String korName;
    private String engName;
    private String Symbol;
    private String unit;
    private List<LocalDate> dateList;
    private List<Float> pirceList;
}
