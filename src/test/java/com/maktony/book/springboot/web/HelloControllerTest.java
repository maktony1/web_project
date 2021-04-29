package com.maktony.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
//여기서는 SpringRunner라는 스프링 ㅅ실행자를 사용
//즉 스프링부트 테스트와 JUnit 사이에 연결자 역할
@RunWith(SpringRunner.class)

//여러 스프링 테스트 어노테이션중 Web(Spring MVC)에 집중할 수 있는 어노테이션
//선언할 경우 @Controller, @ControllerAdvice 등 사용가능
//@Service, @Component, @Repository 등은 사용불가
//여기서는 컨트롤러만 사용하기 때문에 선언
@WebMvcTest(controllers = HelloController.class)

public class HelloControllerTest {

    //스프링이 관리하는 빈(Bean)을 주입 받음
    @Autowired
    //웹API를 테스트할때 사용, 스프링 MVC 테스트의 시작점, 이 클래스를 통해서 HTTP GET,POST 등 API 테스트를 할 수 있음
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        //MockMvc를 통해 /hello주소로 HTTP GET 요청을 함, 체이닝이 지원되어 아래와 같이 여러 검증기능을 이어서 선언가능
        mvc.perform(get("/hello"))
                //mvc.perform의 결과를 검증,HTTP Header의 Status를 검증, 200,404,500등의 상태 검증,200인지 아닌지검증
                .andExpect(status().isOk())
                //mvc.perform의 결과를 검증합니다.
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name",name) //API 테스트할 때 사용될 요청 파라미터를 설정, 단 값은 String만 허용, 따라서 숫자/날짜 등 데이터 등록할때 문자열로 변경해야만 가능
                .param("amount",String.valueOf(amount)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //JSON 응답값을 필드별로 검증할 수 있는 메소드, $를 기준으로 필드명 명시, 여기서 name과 amount를 검증하니 $.name, $.amount로 검증
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
