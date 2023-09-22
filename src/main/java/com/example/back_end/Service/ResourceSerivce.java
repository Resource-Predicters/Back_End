package com.example.back_end.Service;


import com.example.back_end.Entity.ResourcePriceInfoIdTb;
import com.example.back_end.Entity.ResourcePriceInfoTb;
import com.example.back_end.Entity.ResourceTb;
import com.example.back_end.Entity.UnitTb;
import com.example.back_end.Repository.ResourceInfoRepository;
import com.example.back_end.Repository.ResourceTbRepository;
import com.example.back_end.Repository.UnitTbRepository;
import com.example.back_end.dto.Resource.ResourcePriceInfoTbSaveDto;
import com.example.back_end.dto.Resource.ResourceTbSaveDto;
import com.example.back_end.dto.Resource.UnitTbSaveDto;
import com.example.back_end.vo.Resource.ResourceAllVo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
        for (ResourcePriceInfoTbSaveDto dto : requestDto)
        {
            ResourcePriceInfoIdTb A =  ResourcePriceInfoIdTb.builder()
                    .resourceDatePk(LocalDate.parse(dto.getResourceDatePk(), DateTimeFormatter.ISO_DATE)).build();
            ResourcePriceInfoTb entity = dto.toEntity(
                    A,
                    FindIdBySymbol(dto.getResourceTbSymbol()),
                    FindIdByUnit(dto.getUnitIdName()));
            infoRepository.save(entity);
        }
        return 1;
    }

//    public List<ResourceAllVo> GetInfo(LocalDate startDate)
    public List<ResourceAllVo> GetInfo(String Date)

    {
        LocalDate startDate = LocalDate.parse(Date, DateTimeFormatter.ISO_DATE);
        LocalDate endDate = LocalDate.now();
        List<ResourcePriceInfoTb> result = infoRepository.findByResourcePriceInfoIdTb_ResourceDatePkBetweenOrderByResourceIdMk_resourceIdPk(startDate, endDate);


        // 아래꺼 해결
                List<ResourceAllVo> voList = result.stream().map(
                resourcePriceInfoTb -> ResourceAllVo.builder()
                        .date(resourcePriceInfoTb.getResourcePriceInfoIdTb().getResourceDatePk())
                        .price(resourcePriceInfoTb.getPrice())
                        .korName(resourcePriceInfoTb.getResourceIdMk().getResourceKorName())
                        .engName(resourcePriceInfoTb.getResourceIdMk().getResourceEngName())
                        .Symbol(resourcePriceInfoTb.getResourceIdMk().getResourceSymbol())
                        .unit(resourcePriceInfoTb.getUnitIdFk().getUnitName())
                        .build()
        ).collect(Collectors.toList());

        return voList;
       // return null;
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
