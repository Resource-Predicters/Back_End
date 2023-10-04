package com.example.back_end.Service;

import com.example.back_end.Entity.*;
import com.example.back_end.Repository.ExchangeInfoTbRepository;
import com.example.back_end.Repository.ExchangeTbRepository;
import com.example.back_end.dto.Exchange.ExchageInfoTbSaveDto;
import com.example.back_end.dto.Exchange.ExchageTbSaveDto;
import com.example.back_end.vo.Resource.ExchangeInfoVo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ExchageService {

    private final ExchangeTbRepository tbRepository;
    private final ExchangeInfoTbRepository infoRepository;

    public ExchageService(
            ExchangeTbRepository tbRepository,
            ExchangeInfoTbRepository infoRepository
    )
    {
        this.tbRepository = tbRepository;
        this.infoRepository = infoRepository;
    }

    public void TbSave(ExchageTbSaveDto requestDto)
    {
        tbRepository.save(requestDto.toEntity());
    }

    public void InfoSave(List<ExchageInfoTbSaveDto> requestDto)
    {
        List<ExchangeInfoTb> entityList = new ArrayList<ExchangeInfoTb>();
        String CurrencyName = "";
        ExchangeTb exchangeTb = null;
        for (ExchageInfoTbSaveDto dto : requestDto)
        {
            ExchangeInfoIdTb AId = ExchangeInfoIdTb.builder()
                    .exchangeDatePk(LocalDate.parse(dto.getExchangeDatePk(), DateTimeFormatter.ISO_DATE))
                    .build();
            if(!Objects.equals(CurrencyName, dto.getCurrencyName()))
            {
                CurrencyName = dto.getCurrencyName();
                exchangeTb = findByCurrencyName(dto.getCurrencyName());
            }
            ExchangeInfoTb saveEntity = dto.toEntity(
                    AId,
                    exchangeTb);
            entityList.add(saveEntity);
        }
        infoRepository.saveAll(entityList);
    }

    public List<ExchangeInfoVo>GetInfo(String Date)

    {
        LocalDate startDate = LocalDate.parse(Date, DateTimeFormatter.ISO_DATE);
        LocalDate endDate = LocalDate.now();
        List<ExchangeInfoTb> result = infoRepository.findByExchangeInfoIdTb_ExchangeDatePkBetween(startDate, endDate);


        List<ExchangeInfoVo> voList = result.stream().map(
                resourcePriceInfoTb -> ExchangeInfoVo.builder()
                        .date(resourcePriceInfoTb.getExchangeInfoIdTb().getExchangeDatePk())
                        .exchangeRate(resourcePriceInfoTb.getExchangeRate())
                        .currencyName(resourcePriceInfoTb.getCurrencyIdPk().getCurrencyName())
                        .currencySymbol(resourcePriceInfoTb.getCurrencyIdPk().getCurrencySymbol())
                        .currency(resourcePriceInfoTb.getCurrencyIdPk().getCountry())
                        .build()
        ).collect(Collectors.toList());
        return voList;
    }

    public ExchangeTb findByCurrencyName(String CurrencyName) {
        return tbRepository.findByCurrencyName(CurrencyName).get();
    }

    public List<ExchangeTb> getTbAll()
    {
        return tbRepository.findAll();
    }
}
