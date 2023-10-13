package com.example.back_end;

import com.example.back_end.Entity.Exchange.ExchangeInfoTb;
import com.example.back_end.Entity.Exchange.ExchangeTb;
import com.example.back_end.Repository.*;
import com.example.back_end.dto.Exchange.ExchageInfoTbSaveDto;
import com.example.back_end.dto.Exchange.ExchageTbSaveDto;
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
public class ExchangeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ExchangeTbRepository tbRepository;
    @Autowired
    private ExchangeInfoTbRepository infoRepository;

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
    public void ExchangeTb_save_test() throws Exception{

        //given
        List<String> currencyName = new ArrayList<String>();
        currencyName.add("USD");
        currencyName.add("RMB");
        List<String> currencySymbol = new ArrayList<String>();
        currencySymbol.add("$");
        currencySymbol.add("Â¥");
        List<String> country = new ArrayList<String>();
        country.add("United States");
        country.add("China");

        for(int i = 0; i < currencyName.size(); i++)
        {
            ExchageTbSaveDto requestDto = ExchageTbSaveDto.builder()
                    .currencyName(currencyName.get(i))
                    .currencySymbol(currencySymbol.get(i))
                    .country(country.get(i))
                    .build();

            String url = "http://localhost:" + port + "/exchange/tbsave";
            //when
            mvc.perform(post(url)
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(new ObjectMapper().writeValueAsString(requestDto)))
                    .andExpect(status().isOk());
        }
        //then
        List<ExchangeTb> all = tbRepository.findAll();
//        assertThat(all.get(0).getCountry()).isEqualTo(country.get(0));
    }

    @Test
    public void ExchangeTbInfoSaveTest()throws Exception {

        //given

        List<Float> exchangeRate = new ArrayList<Float>();
        exchangeRate.add(1325.82f);
        exchangeRate.add(182.47f);
        List<String> currencyName = new ArrayList<String>();
        currencyName.add("USD");
        currencyName.add("RMB");

        List<ExchageInfoTbSaveDto> requestDto = new ArrayList<ExchageInfoTbSaveDto>();
        for (int j = 0; j < exchangeRate.size(); j++) {
            for (int i = 1; i < 30; i++) {
                String exchangeDatePk = "";
                if (i < 10) {
                    exchangeDatePk = "2023-09-0" + Integer.toString(i);
                } else {
                    exchangeDatePk = "2023-09-" + Integer.toString(i);
                }
                ExchageInfoTbSaveDto entity = ExchageInfoTbSaveDto.builder()
                        .exchangeDatePk(exchangeDatePk)
                        .exchangeRate(exchangeRate.get(j) + i)
                        .currencyName(currencyName.get(j))
                        .build();
                requestDto.add(entity);
            }
        }
        String url = "http://localhost:" + port + "/exchange/infosave";
        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());
        List<ExchangeInfoTb> all = infoRepository.findAll();
//        assertThat(all.get(0).getExchangeDatePk()).isEqualTo(exchangeDatePk);
    }

    @Test
    public void TestAll()throws Exception {
        ExchangeTb_save_test();
        ExchangeTbInfoSaveTest();
    }
}
