package com.example.back_end.Controller;


import com.example.back_end.Entity.Exchange.ExchangeTb;
import com.example.back_end.Service.ExchageService;
import com.example.back_end.dto.Exchange.ExchageInfoTbSaveDto;
import com.example.back_end.dto.Exchange.ExchageTbSaveDto;
import com.example.back_end.vo.Exchange.ExchangeInfoVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/exchange")
public class ExchangeController {
    private final ExchageService exchageService;
    public ExchangeController(ExchageService exchageService)
    {
        this.exchageService = exchageService;
    }

    @PostMapping("/tbsave")
    public void TbSave(@RequestBody ExchageTbSaveDto requestDto)
    {
        exchageService.TbSave(requestDto);
    }

    @PostMapping("/infosave")
    public void InfoSave(@RequestBody List<ExchageInfoTbSaveDto> requestDto)
    {
        exchageService.InfoSave(requestDto);
    }

    @GetMapping("/getinfo")
    public ResponseEntity<Object> GetInfo(String date)
    {
        List<ExchangeInfoVo> result = exchageService.GetInfo(date);
        return ResponseEntity.ok().body(
                result);
    }

    @GetMapping ("/gettball")
    public List<ExchangeTb> GetCode()
    {
        return exchageService.getTbAll();
    }
}
