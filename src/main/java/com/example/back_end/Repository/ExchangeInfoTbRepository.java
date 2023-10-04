package com.example.back_end.Repository;

import com.example.back_end.Entity.ExchangeInfoIdTb;
import com.example.back_end.Entity.ExchangeInfoTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ExchangeInfoTbRepository extends JpaRepository<ExchangeInfoTb, ExchangeInfoIdTb> {
    @Query(value ="SELECT i, r " +
            "FROM ExchangeInfoTb i LEFT OUTER JOIN ExchangeTb r on i.currencyIdPk = r " +
            "WHERE i.exchangeInfoIdTb.exchangeDatePk BETWEEN :start AND :end " +
            "ORDER BY i.exchangeInfoIdTb.currentyIdPk, i.exchangeInfoIdTb.exchangeDatePk "
    )
    List<ExchangeInfoTb> findByExchangeInfoIdTb_ExchangeDatePkBetween(LocalDate start, LocalDate end);
}
