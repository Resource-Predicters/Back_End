package com.example.back_end.Entity.Exchange;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Embeddable
public class ExchangeInfoIdTb implements Serializable {


    private LocalDate exchangeDatePk;

    private int currentyIdPk;

    @Builder
    public ExchangeInfoIdTb(LocalDate exchangeDatePk, int currentyIdPk) {
        this.exchangeDatePk = exchangeDatePk;
        this.currentyIdPk = currentyIdPk;
    }


}
