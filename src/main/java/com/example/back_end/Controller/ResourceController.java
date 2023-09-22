package com.example.back_end.Controller;


import com.example.back_end.Entity.ResourceTb;
import com.example.back_end.Service.ResourceSerivce;
import com.example.back_end.dto.Resource.ResourcePriceInfoTbSaveDto;
import com.example.back_end.dto.Resource.ResourceTbSaveDto;
import com.example.back_end.dto.Resource.UnitTbSaveDto;
import com.example.back_end.vo.Resource.ResourceAllVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/resource")
public class ResourceController {

    private final ResourceSerivce resourceSerivce;
    public ResourceController(ResourceSerivce resourceSerivce)
    {
        this.resourceSerivce = resourceSerivce;
    }


    @PostMapping("/tbsave")
    public int TbSave(@RequestBody ResourceTbSaveDto requestDto )
    {
        return resourceSerivce.ResourceCodeSave(requestDto);
    }
    @PostMapping("/infosave")
    public int InfoSave(@RequestBody List<ResourcePriceInfoTbSaveDto> requestDto )
    {
        return resourceSerivce.ResourceInfoSave(requestDto);
    }
    @GetMapping("/getinfoall")
    public ResponseEntity<Object> GetInfo(String date)
    {
        List<ResourceAllVo> result = resourceSerivce.GetInfo(date);
        return ResponseEntity.ok().body(
                result);
    }

    @PostMapping("/unitsave")
    public int UnitSave(@RequestBody UnitTbSaveDto requestDto)
    {
        return resourceSerivce.UnitSave(requestDto);
    }

    @GetMapping ("/gettball")
    public List<ResourceTb> GetCode()
    {
        return resourceSerivce.GetTbAll();
    }



//    @GetMapping("/getItme")
//    public ResponseEntity<Object> getItme()
//    {
//        List<ResourceAllVo> result = resourceSerivce.ResourceAll();
//        return ResponseEntity.ok().body(
//                result);
//    }



}
