package com.example.back_end;

import com.example.back_end.Entity.User.UserEntity;
import com.example.back_end.Repository.UserEntityRepository;
import com.example.back_end.dto.User.UserJoinDto;
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
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserEntityRepository userEntityRepository;

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
    public void join_test() throws Exception {
        //given

        String name = "test";
        String password = "qwer1234";


            UserJoinDto requestDto = UserJoinDto.builder()
                    .name(name)
                    .password(password)
                    .build();

            String url = "http://localhost:" + port + "/user/join";
            //when
            mvc.perform(post(url)
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(new ObjectMapper().writeValueAsString(requestDto)))
                    .andExpect(status().isOk());

        //then
        List<UserEntity> all = userEntityRepository.findAll();
//        assertThat(all.get(0).getCountry()).isEqualTo(country.get(0));
    }

    @Test
    public void login_test() throws Exception {
        //given

        String name = "test";
        String password = "qwer1234";


        UserJoinDto requestDto = UserJoinDto.builder()
                .name(name)
                .password(password)
                .build();

        String url = "http://localhost:" + port + "/user/login";
        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<UserEntity> all = userEntityRepository.findAll();
//        assertThat(all.get(0).getCountry()).isEqualTo(country.get(0));
    }

}
