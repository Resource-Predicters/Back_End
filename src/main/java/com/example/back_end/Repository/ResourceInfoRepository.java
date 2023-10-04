package com.example.back_end.Repository;


import com.example.back_end.Entity.ResourcePriceInfoIdTb;
import com.example.back_end.Entity.ResourcePriceInfoTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ResourceInfoRepository extends JpaRepository<ResourcePriceInfoTb, ResourcePriceInfoIdTb> {
    @Query(value ="SELECT i, r, u " +
            "FROM ResourcePriceInfoTb i LEFT OUTER JOIN ResourceTb r on i.resourceIdMk = r " +
            "LEFT OUTER JOIN UnitTb u on i.unitIdFk = u " +
            "WHERE i.resourcePriceInfoIdTb.resourceDatePk BETWEEN :start AND :end " +
            "ORDER By i.resourcePriceInfoIdTb.resourceIdMk, i.resourcePriceInfoIdTb.resourceDatePk "
            )
    List<ResourcePriceInfoTb> findByResourcePriceInfoIdTb_ResourceDatePkBetweenOrderByResourceIdMk_resourceIdPk(LocalDate start, LocalDate end);
}
//ResourceIdMk