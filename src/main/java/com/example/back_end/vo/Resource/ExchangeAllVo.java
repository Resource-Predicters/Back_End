package com.example.back_end.vo.Resource;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ExchangeAllVo {
    private LocalDate date;
    private Float exchangeRate;
    private String currencyName;
    private String currencySymbol;
    private String currency;
}
