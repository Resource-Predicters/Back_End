package com.example.back_end.Service;


import com.example.back_end.Entity.IssueTb;
import com.example.back_end.Entity.ResourceTb;
import com.example.back_end.Repository.IssueTbRepository;
import com.example.back_end.Repository.ResourceTbRepository;
import com.example.back_end.dto.issue.IssueSaveTbDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    public void TbSave(IssueSaveTbDto issueTbDto)
    {
        tbRepository.save(issueTbDto.toEntity(FindResourceTbID(issueTbDto.getResourceSymbol()),LocalDate.parse(issueTbDto.getIssueDate(), DateTimeFormatter.ISO_DATE)));
    }
    public List<IssueTb> find(String Date)
    {
        LocalDate startDate = LocalDate.parse(Date, DateTimeFormatter.ISO_DATE);
        LocalDate endDate = LocalDate.now();
        return tbRepository.findByIssueDateBetween(startDate, endDate);
    }
    public ResourceTb FindResourceTbID(String symbol)
    {
        return resourceTbRepository.findByResourceSymbol(symbol).get();
    }
}
