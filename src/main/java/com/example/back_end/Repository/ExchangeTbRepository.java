package com.example.back_end.Repository;

import com.example.back_end.Entity.ExchangeTb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeTbRepository extends JpaRepository<ExchangeTb, Integer> {
        Optional<ExchangeTb> findByCurrencyName(String Name);
}
