package com.example.back_end.Repository;

import com.example.back_end.Entity.IssueTb;
import com.example.back_end.Entity.ResourceTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IssueTbRepository extends JpaRepository<IssueTb, Integer> {
    @Query(value ="SELECT i, r " +
            "FROM IssueTb i LEFT OUTER JOIN ResourceTb r on i.resourceIdPk = r " +
            "WHERE i.issueDate BETWEEN :start AND :end " +
            "ORDER BY i.resourceIdPk.resourceIdPk, i.issueDate"
    )
    List<IssueTb> findByIssueDateBetween(LocalDate start, LocalDate end);


}
