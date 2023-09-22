package com.example.back_end.Service;

import com.example.back_end.Entity.*;
import com.example.back_end.Repository.ExchangeInfoTbRepository;
import com.example.back_end.Repository.ExchangeTbRepository;
import com.example.back_end.dto.Resource.ExchageInfoTbSaveDto;
import com.example.back_end.dto.Resource.ExchageTbSaveDto;
import com.example.back_end.vo.Resource.ExchangeAllVo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
        for (ExchageInfoTbSaveDto dto : requestDto)
        {
            ExchangeInfoIdTb AId = ExchangeInfoIdTb.builder()
                    .exchangeDatePk(LocalDate.parse(dto.getExchangeDatePk(), DateTimeFormatter.ISO_DATE))
                    .build();

            ExchangeInfoTb entity = dto.toEntity(
                    AId,
                    findByCurrencyName(dto.getCurrencyName()));

            infoRepository.save(entity);
        }
    }

    public List<ExchangeAllVo>GetInfo(String Date)

    {
        LocalDate startDate = LocalDate.parse(Date, DateTimeFormatter.ISO_DATE);
        LocalDate endDate = LocalDate.now();
        List<ExchangeInfoTb> result = infoRepository.findByExchangeInfoIdTb_ExchangeDatePkBetween(startDate, endDate);


        List<ExchangeAllVo> voList = result.stream().map(
                resourcePriceInfoTb -> ExchangeAllVo.builder()
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
