package com.example.back_end.Controller;


import com.example.back_end.Entity.IssueTb;
import com.example.back_end.Service.IssueService;
import com.example.back_end.dto.issue.IssueSaveTbDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/issue")
public class IssueController {
    private final IssueService issueService;

    public IssueController(IssueService issueService)
    {
        this.issueService = issueService;
    }
    @PostMapping("/tbsave")
    public void TbSave(@RequestBody IssueSaveTbDto issueTbDto)
    {
        issueService.TbSave(issueTbDto);
    }

    @GetMapping("/findall")
    public ResponseEntity<Object>  Findall(String date)
    {
        List<IssueTb> result = issueService.find(date);
        return ResponseEntity.ok().body(
                result);
    }
}
