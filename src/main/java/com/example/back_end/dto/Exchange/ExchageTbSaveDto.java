package com.example.back_end.dto.Exchange;


import com.example.back_end.Entity.ExchangeTb;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonAutoDetect
@Getter
@NoArgsConstructor
public class ExchageTbSaveDto {
    private String currencyName;
    private String currencySymbol;
    private String country;

    @Builder
    public ExchageTbSaveDto(String currencyName, String currencySymbol, String country)
    {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.country = country;
    }

    public ExchangeTb toEntity()
    {
        return ExchangeTb.builder()
                .currencyName(currencyName)
                .currencySymbol(currencySymbol)
                .country(country)
                .build();
    }
}
