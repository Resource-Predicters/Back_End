package com.example.back_end.Entity;

import com.example.back_end.Repository.IssueTbRepository;
import com.example.back_end.Repository.ResourceTbRepository;
import com.example.back_end.dto.issue.IssueSaveTbDto;
import com.example.back_end.vo.Resource.IssueInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
