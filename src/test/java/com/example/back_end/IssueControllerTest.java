package com.example.back_end;

import com.example.back_end.Entity.IssueTb;
import com.example.back_end.Repository.IssueTbRepository;
import com.example.back_end.dto.issue.IssueSaveTbDto;
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

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IssueControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private IssueTbRepository tbRepository;

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
    public void IssueTb_save_test() throws Exception{
        //given
        String title= "title1";
        String publisher = "publisher1";
        String url = "url1";
        String issueDate = "2023-09-25";
        String resourceSymbol = "Ni";

        IssueSaveTbDto requestDto = IssueSaveTbDto.builder()
                .title(title)
                .publisher(publisher)
                .url(url)
                .issueDate(issueDate)
                .resourceSymbol(resourceSymbol)
                .build();



        String url2 = "http://localhost:" + port + "/issue/tbsave";
        //when
        mvc.perform(post(url2)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<IssueTb> all = tbRepository.findAll();
//        assertThat(all.get(0).getCountry()).isEqualTo(country.get(0));

    }
}
