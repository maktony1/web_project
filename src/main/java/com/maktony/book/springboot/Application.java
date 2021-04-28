package com.maktony.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBootApplication 스프링부트 자동설정, 스프링 Bean 읽기 생성 모두 자동, 이 클래스는 항상 프로젝트 최상단에 위치해야함
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        //메인 메소드를 실행하는 SpringApplication.run 으로 인해 내장 WAS를 실행
        SpringApplication.run(Application.class, args);

    }
}
