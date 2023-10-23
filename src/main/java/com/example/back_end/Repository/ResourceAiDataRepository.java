package com.example.back_end.Repository;

import com.example.back_end.Entity.Resource.ResourceAiDataTb;
import com.example.back_end.Entity.Resource.ResourcePriceInfoIdTb;
import com.example.back_end.Entity.Resource.ResourcePriceInfoTb;
import com.example.back_end.vo.Resource.ResourceInfoVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface ResourceAiDataRepository extends JpaRepository<ResourceAiDataTb, LocalDate> {

    @Query(value ="SELECT a, r " +
            "FROM ResourceAiDataTb a LEFT OUTER JOIN ResourceTb r on a.resourceIdMk = r " +
            "WHERE a.resourceAiDataIdTb.resourceAiDataIdTb BETWEEN :start AND :end " +
            "ORDER By a.resourceIdMk.resourceIdPk, a.resourceAiDataIdTb.resourceAiDataIdTb "
    )
    List<ResourceAiDataTb> findByResourceAiDatePkBetween(LocalDate start, LocalDate end);


}
