//package com.esalon.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.http.HttpClient;
//import java.time.Duration;
//
//@Configuration
//public class HttpConfig {
//
//    @Bean
//    public HttpClient httpClient(){
//        return HttpClient.newBuilder()
//                .followRedirects(HttpClient.Redirect.NORMAL)
//                .connectTimeout(Duration.ofMinutes(3))
//                .build();
//    }
//}
