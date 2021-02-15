package org.example.springboot_webservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication : 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
 *                          메인클래스로 프로젝트의 최상단에 위치해야 한다.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        /*
         * SpringApplication.run() : 내장 was(web application server) 실행
         *                           항상 서버에서 톰캣을 설치할 필요가 없고 스프링 부트로 만들어진 jar파일로 실행하면 된다.
         */
        SpringApplication.run(Application.class, args);
    }
}
