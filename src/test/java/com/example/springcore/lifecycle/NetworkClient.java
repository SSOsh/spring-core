package com.example.springcore.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient
        implements InitializingBean,
//        implements
                DisposableBean {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
//        connect();
//        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message : " + message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close  : " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //의존관계 주입 끝나면 call
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
        connect();
        call("초기화");
    }

    @PreDestroy
    public void close() {
        System.out.println("close");
        disconnect();
        call("닫기");
    }
}
