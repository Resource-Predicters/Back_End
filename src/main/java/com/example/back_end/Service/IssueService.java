package com.example.back_end.Service;

import com.example.back_end.Entity.Issue.IssueTb;
import com.example.back_end.Entity.Resource.ResourceTb;
import com.example.back_end.Repository.IssueTbRepository;
import com.example.back_end.Repository.ResourceTbRepository;
import com.example.back_end.dto.issue.IssueSaveTbDto;
import com.example.back_end.vo.Issue.IssueInfoVo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {
    private final IssueTbRepository tbRepository;
    private final ResourceTbRepository resourceTbRepository;
    public IssueService(IssueTbRepository tbRepository,
                        ResourceTbRepository resourceTbRepository)
    {
        this.tbRepository = tbRepository;
        this.resourceTbRepository = resourceTbRepository;
    }
    public void TbSave(List<IssueSaveTbDto> requestDto)
    {
        List<IssueTb> entityList = new ArrayList<IssueTb>();
        //        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (IssueSaveTbDto dto : requestDto)
        {
            IssueTb saveEntity = dto.toEntity(
                    FindResourceTbID(dto.getResourceSymbol()),
                    LocalDate.parse(dto.getIssueDate(), DateTimeFormatter.ofPattern("yyyy.MM.dd.")));
            entityList.add(saveEntity);
        }
        tbRepository.saveAll(entityList);
    }
    public List<IssueInfoVo> find(String Date)
    {
        LocalDate startDate = LocalDate.parse(Date, DateTimeFormatter.ISO_DATE);
        LocalDate endDate = LocalDate.now();
        List<IssueTb> result = tbRepository.findByIssueDateBetween(startDate, endDate);
        List<IssueInfoVo> voList =  result.stream().map(
                IssueTb -> IssueInfoVo.builder()
                        .title(IssueTb.getTitle())
                        .publisher(IssueTb.getPublisher())
                        .url(IssueTb.getUrl())
                        .issueDate(IssueTb.getIssueDate())
                        .resourceKorName(IssueTb.getResourceIdPk().getResourceKorName())
                        .resourceEngName(IssueTb.getResourceIdPk().getResourceEngName())
                        .resourceSymbol(IssueTb.getResourceIdPk().getResourceSymbol())
                        .build()
        ).collect(Collectors.toList());

        return voList;
    }
    public ResourceTb FindResourceTbID(String symbol)
    {
        return resourceTbRepository.findByResourceSymbol(symbol).get();
    }
}