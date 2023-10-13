package com.example.back_end.vo.Issue;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
@Builder
public class IssueInfoVo {
    private String title;
    private String publisher;
    private String url;
    private LocalDate issueDate;
    private String resourceKorName;
    private String resourceEngName;
    private String resourceSymbol;
}
