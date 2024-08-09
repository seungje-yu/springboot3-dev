package com.coffit.springbootdev.test.controller;

import com.coffit.springbootdev.test.domain.Member;
import com.coffit.springbootdev.test.model.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest     // 테스트용 애플리케이션 컨텍스트 생성
@AutoConfigureMockMvc   // MockMvc 생성 및 자동 구성
class TestControllerTest {

    @Autowired
    protected MockMvc mvc;
    // MockMvc는 애플리케이션을 서버에 배포하지 않고도 테스트용 mvc환경을 만들어서
    // 요청 및 전송, 응답 기능을 제공하는 유틸리티(컨트롤러를 테스트할 때 사용되는 클래스)

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void mockMvcSetup(){
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    public void cleanup(){
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers: 조회 성공")
    @Test
    public void getAllMembers() throws Exception {

        // given
        final String url = "/test";
        Member saveMember = memberRepository.save(new Member(1L, "홍길동"));
        // when

        final ResultActions result = mvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(saveMember.getId()))
                .andExpect(jsonPath("$[0].name").value(saveMember.getName()));
    }
}