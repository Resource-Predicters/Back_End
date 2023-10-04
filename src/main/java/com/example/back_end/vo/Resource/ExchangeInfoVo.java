package com.example.back_end.vo.Resource;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
@Builder
public class ExchangeInfoVo {
    private LocalDate date;
    private Float exchangeRate;
    private String currencyName;
    private String currencySymbol;
    private String currency;
}
