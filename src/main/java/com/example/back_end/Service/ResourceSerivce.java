package com.example.back_end.Service;


import com.example.back_end.Entity.Resource.ResourcePriceInfoIdTb;
import com.example.back_end.Entity.Resource.ResourcePriceInfoTb;
import com.example.back_end.Entity.Resource.ResourceTb;
import com.example.back_end.Entity.Unit.UnitTb;
import com.example.back_end.Repository.ResourceInfoRepository;
import com.example.back_end.Repository.ResourceTbRepository;
import com.example.back_end.Repository.UnitTbRepository;
import com.example.back_end.dto.Resource.ResourcePriceInfoTbSaveDto;
import com.example.back_end.dto.Resource.ResourceTbSaveDto;
import com.example.back_end.dto.Resource.UnitTbSaveDto;
import com.example.back_end.vo.Resource.ResourceInfoVo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ResourceSerivce {

    private final ResourceTbRepository tbRepository;
    private final ResourceInfoRepository infoRepository;
    private final UnitTbRepository unitRepository;

    public ResourceSerivce(ResourceTbRepository tbRepository,
                           ResourceInfoRepository infoRepository,
                           UnitTbRepository unitRepository)
    {
        this.tbRepository = tbRepository;
        this.infoRepository = infoRepository;
        this.unitRepository = unitRepository;
    }

    public int ResourceCodeSave(ResourceTbSaveDto requestDto)
    {
        return tbRepository.save(requestDto.toEntity()).getResourceIdPk();
    }
    public int UnitSave(UnitTbSaveDto requestDto)
    {
        return unitRepository.save(requestDto.toEntity()).getUnitIdPk();
    }


//    public int ResourceInfoSave(List<Resource_price_info_tb_save_dto> requestDto)
    public int ResourceInfoSave(List<ResourcePriceInfoTbSaveDto> requestDto)
    {
        List<ResourcePriceInfoTb> entityList = new ArrayList<ResourcePriceInfoTb>();
        String symbol = "";
        UnitTb unitTb = null;
        ResourceTb resourceTb = null;
        for (ResourcePriceInfoTbSaveDto dto : requestDto)
        {
            ResourcePriceInfoIdTb A =  ResourcePriceInfoIdTb.builder()
                    .resourceDatePk(LocalDate.parse(dto.getResourceDatePk(), DateTimeFormatter.ISO_DATE)).build();

            if(!Objects.equals(symbol, dto.getResourceTbSymbol()))
            {
                symbol = dto.getResourceTbSymbol();
                unitTb = FindIdByUnit(dto.getUnitIdName());
                resourceTb =FindIdBySymbol(dto.getResourceTbSymbol());
            }
            ResourcePriceInfoTb saveEntity = dto.toEntity(
                    A,
                    resourceTb,
                    unitTb);
            entityList.add(saveEntity);
        }
        infoRepository.saveAll(entityList);
        return 1;
    }

    public List<ResourceInfoVo> GetInfo(String Date)

    {
        LocalDate startDate = LocalDate.parse(Date, DateTimeFormatter.ISO_DATE);
        LocalDate endDate = LocalDate.now();
        List<ResourcePriceInfoTb> result = infoRepository.findByResourcePriceInfoIdTb_ResourceDatePkBetweenOrderByResourceIdMk_resourceIdPk(startDate, endDate);
        List<ResourceInfoVo> voList = result.stream().map(
                resourcePriceInfoTb -> ResourceInfoVo.builder()
                        .date(resourcePriceInfoTb.getResourcePriceInfoIdTb().getResourceDatePk())
                        .price(resourcePriceInfoTb.getPrice())
                        .korName(resourcePriceInfoTb.getResourceIdMk().getResourceKorName())
                        .engName(resourcePriceInfoTb.getResourceIdMk().getResourceEngName())
                        .Symbol(resourcePriceInfoTb.getResourceIdMk().getResourceSymbol())
                        .unit(resourcePriceInfoTb.getUnitIdFk().getUnitName())
                        .build()
        ).collect(Collectors.toList());
        return voList;
    }


    /////////////////////////////////////////////////////////////////////////////////
    public ResourceTb FindIdBySymbol(String Resource_tb_symbol)
    {
        return tbRepository.findByResourceSymbol(Resource_tb_symbol).get();
    }
    public UnitTb FindIdByUnit(String unit_name)
    {
        return unitRepository.findByUnitName(unit_name).get();
    }

    public List<ResourceTb> GetTbAll()
    {
        return tbRepository.findAll();
    }
}
