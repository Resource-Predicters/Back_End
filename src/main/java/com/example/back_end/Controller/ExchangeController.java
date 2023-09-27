package com.example.back_end;


import com.example.back_end.Entity.ExchangeTb;
import com.example.back_end.Service.ExchageService;
import com.example.back_end.dto.Exchange.ExchageInfoTbSaveDto;
import com.example.back_end.dto.Exchange.ExchageTbSaveDto;
import com.example.back_end.vo.Resource.ExchangeAllVo;
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

    @GetMapping("/getinfoall")
    public ResponseEntity<Object> GetInfo(String date)
    {

        // 값은 불러와 지지만 기간으로 불러와지지 않고 모든 데이터가 불러와 진다
        // resourceDatePk 빈값으로 출력 된다
        List<ExchangeAllVo> result = exchageService.GetInfo(date);
        return ResponseEntity.ok().body(
                result);
    }

    @GetMapping ("/gettball")
    public List<ExchangeTb> GetCode()
    {
        return exchageService.getTbAll();
    }

    //get info


}
