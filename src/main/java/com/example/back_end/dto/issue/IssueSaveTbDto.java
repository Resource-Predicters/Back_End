package com.example.back_end.dto.issue;

import com.example.back_end.Entity.Issue.IssueTb;
import com.example.back_end.Entity.Resource.ResourceTb;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@JsonAutoDetect
@Getter
@NoArgsConstructor
public class IssueSaveTbDto {
    private String title;
    private String publisher;
    private String url;
    private String issueDate;
    private String resourceSymbol;


    @Builder
    public IssueSaveTbDto(
            String title,
            String publisher,
            String url,
            String issueDate,
            String resourceSymbol)
    {
        this.title = title;
        this.publisher = publisher;
        this.url = url;
        this.issueDate = issueDate;
        this.resourceSymbol = resourceSymbol;
    }

    public IssueTb toEntity(ResourceTb resourceIdPk, LocalDate issueDate)
    {
        return IssueTb.builder()
                .title(title)
                .publisher(publisher)
                .url(url)
                .issueDate(issueDate)
                .resourceIdPk(resourceIdPk)
                .build();
    }


}
