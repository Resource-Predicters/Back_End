package com.example.back_end.dto.Exchange;


import com.example.back_end.Entity.ExchangeInfoIdTb;
import com.example.back_end.Entity.ExchangeInfoTb;
import com.example.back_end.Entity.ExchangeTb;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonAutoDetect
@Getter
@NoArgsConstructor
public class ExchageInfoTbSaveDto {
    private String  exchangeDatePk;
    private Float exchangeRate;
    private String currencyName;

    @Builder
    public ExchageInfoTbSaveDto(
            String exchangeDatePk,
            Float exchangeRate,
            String currencyName)
    {
        this.exchangeDatePk = exchangeDatePk;
        this.exchangeRate = exchangeRate;
        this.currencyName = currencyName;
    }

    public ExchangeInfoTb toEntity(ExchangeInfoIdTb exchangeInfoIdTb , ExchangeTb currencyIdPk)
    {
        return ExchangeInfoTb.builder()
                .exchangeInfoIdTb(exchangeInfoIdTb)
                .exchangeRate(exchangeRate)
                .currencyIdPk(currencyIdPk)
                .build();
    }
}
