package com.example.back_end.Entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ExchangeInfoTb {

    @EmbeddedId
    private ExchangeInfoIdTb exchangeInfoIdTb;

    @NotNull
    private Float exchangeRate;

    @MapsId("currentyIdPk")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ExchangeTbCurrentyIdPk")
    private ExchangeTb currencyIdPk;


    @Builder
    public ExchangeInfoTb(ExchangeInfoIdTb exchangeInfoIdTb,
                          Float exchangeRate,
                          ExchangeTb currencyIdPk
    ) {
        this.exchangeInfoIdTb = exchangeInfoIdTb;
        this.exchangeRate = exchangeRate;
        this.currencyIdPk = currencyIdPk;
    }


}
