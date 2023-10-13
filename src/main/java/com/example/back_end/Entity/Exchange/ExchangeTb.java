package com.example.back_end.Entity.Exchange;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ExchangeTb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int currentyIdPk;

    @NotNull
    @Column(unique = true, columnDefinition = "varchar (40)")
    private String currencyName;

    @NotNull
    @Column(unique = true, columnDefinition = "varchar (10)")
    private String currencySymbol;

    @NotNull
    @Column(unique = true, columnDefinition = "varchar (40)")
    private String country;

    @Builder
    public ExchangeTb(String currencyName,
                      String currencySymbol,
                      String country
                       ) {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.country = country;
    }
}
