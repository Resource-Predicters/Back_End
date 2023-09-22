package com.example.back_end.Repository;


import com.example.back_end.Entity.ResourceTb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResourceTbRepository extends JpaRepository<ResourceTb, Integer> {
    Optional<ResourceTb> findByResourceSymbol(String Symbol);
}
