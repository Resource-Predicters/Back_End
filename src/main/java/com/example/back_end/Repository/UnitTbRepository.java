package com.example.back_end.Repository;

import com.example.back_end.Entity.UnitTb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitTbRepository extends JpaRepository<UnitTb, Integer> {
    Optional<UnitTb> findByUnitName(String unit_name);
}
