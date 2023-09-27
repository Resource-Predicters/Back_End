package com.example.back_end;

import com.example.back_end.Entity.ResourcePriceInfoTb;
import com.example.back_end.Entity.ResourceTb;
import com.example.back_end.Entity.UnitTb;
import com.example.back_end.Repository.ResourceInfoRepository;
import com.example.back_end.Repository.ResourceTbRepository;
import com.example.back_end.Repository.UnitTbRepository;
import com.example.back_end.dto.Resource.ResourcePriceInfoTbSaveDto;
import com.example.back_end.dto.Resource.ResourceTbSaveDto;
import com.example.back_end.dto.Resource.UnitTbSaveDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ResourceControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ResourceTbRepository codeRepository;
    @Autowired
    private ResourceInfoRepository infoRepository;
    @Autowired
    private UnitTbRepository unitRepository;

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void ResourceTb_save_test() throws Exception{
        //given
        List<String> resourceEngName = new ArrayList<String>();
        resourceEngName.add("Nickel");
        resourceEngName.add("Lithum");
        resourceEngName.add("Ferrite");
        resourceEngName.add("Cobalt");

        List<String> resourceKorName = new ArrayList<String>();
        resourceKorName.add("니켈");
        resourceKorName.add("리튬");
        resourceKorName.add("철스크랩");
        resourceKorName.add("코발트");

        List<String> resourceSymbol = new ArrayList<String>();
        resourceSymbol.add("Ni");
        resourceSymbol.add("Li");
        resourceSymbol.add("Fe");
        resourceSymbol.add("Co");

    for (int i = 0; i < resourceEngName.size(); i++)
    {
        ResourceTbSaveDto requestDto = ResourceTbSaveDto.builder()
                .resourceEngName(resourceEngName.get(i))
                .resourceKorName(resourceKorName.get(i))
                .resourceSymbol(resourceSymbol.get(i))
                .build();

        String url = "http://localhost:" + port + "/resource/tbsave";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
    }


        //then
        List<ResourceTb> all = codeRepository.findAll();

//        assertThat(all.get(0).getResourceEngName()).isEqualTo(resourceEngName);
//        assertThat(all.get(0).getResourceKorName()).isEqualTo(resourceKorName);
//        assertThat(all.get(0).getResourceSymbol()).isEqualTo(resourceSymbol);
    }

    @Test
    public void UnitTb_save_test() throws Exception{
        String unitName = "USD/ton";
        UnitTbSaveDto requestDto = UnitTbSaveDto.builder()
                .unitName(unitName)
                .build();
        String url = "http://localhost:" + port + "/resource/unitsave";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        List<UnitTb> all = unitRepository.findAll();
//        assertThat(all.get(0).getUnitName()).isEqualTo(unitName);
    }


    @Test
    public void Info_save_test() throws Exception{
        //given
//        String resourceDatePk = "2023-09-15";
        List<Float> price = new ArrayList<Float>() ;
        price.add(20255f);
        price.add(172.5f);
        price.add(505f);
        price.add(33420f);
        List<String> resourceSymbol = new ArrayList<String>();
        resourceSymbol.add("Ni");
        resourceSymbol.add("Li");
        resourceSymbol.add("Fe");
        resourceSymbol.add("Co");
        String unit_id_name = "USD/ton";

        List<ResourcePriceInfoTbSaveDto> requests = new ArrayList<ResourcePriceInfoTbSaveDto>();

        int index = 0;
        for (int j = 0; j < 4; j++)
        {
            for (int i = 1; i < 30; i++)
            {
                String resourceDatePk = "";
                if(i < 10) { resourceDatePk = "2023-09-0" + Integer.toString(i); }
                else { resourceDatePk = "2023-09-" + Integer.toString(i); }
                ResourcePriceInfoTbSaveDto entity = ResourcePriceInfoTbSaveDto.builder()
                        .resourceDatePk(resourceDatePk)
                        .price(price.get(j) + i)
                        .resourceTbSymbol(resourceSymbol.get(j))
                        .unitIdName(unit_id_name)
                        .build();
                requests.add(entity);
            }
        }

        String url = "http://localhost:" + port + "/resource/infosave";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requests)))
                .andExpect(status().isOk());

        //then
        List<ResourcePriceInfoTb> all = infoRepository.findAll();
//       assertThat(all.get(0).getResourceDatePk()).isEqualTo(resourceDatePk);
//        assertThat(all.get(0).getResource_kor_name()).isEqualTo(price);
    }


    @Test
    public void TestAll()throws Exception {
        UnitTb_save_test();
        ResourceTb_save_test();
        Info_save_test();
    }
}
