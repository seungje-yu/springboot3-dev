package com.coffit.springbootdev.test.controller;

import com.coffit.springbootdev.test.domain.Member;
import com.coffit.springbootdev.test.model.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* spring-boot-starter-web : Spring MVC를 사용해서 RESTful 웹 서비스를 개발할 때 필요한 의존성모음
* spring-boot-starter-test : 스프링 애플리케이션을 테스트하기 위해 필요한 의존성 모음
* spring-boot-starter-validation : 유효성 검사를 위해 의존성 모음
* spring-boot-starter-actuator : 모니터링을 위해 애플리케이션에서 제공하는 다양한 정보를 제공하기 쉽게 하는 의존성 모음
* spring-boot-starter-data-jpa : ORM을 사용하기 위한 인터페이스의 모음인 JPA를 더 쉽게 사용하기 위한 의존성 모음
*
* 의존성 버전확인(spring.io)
* https://docs.spring.io/spring-boot/appendix/dependency-versions/coordinates.html
*
* 스타터의 의존성확인(github site)
* https://github.com/spring-projects/spring-boot/tree/main/spring-boot-project/spring-boot-starters
* */
@RestController
@RequiredArgsConstructor
public class TestController {


    TestService testService;

//    @GetMapping("/test")
//    public String test() {
//        return "Hello world!";
//    }


    @GetMapping("/test")
    public List<Member> getAllMembers() {

        List<Member> members = testService.getAllMembers();
        return members;
    }
}
