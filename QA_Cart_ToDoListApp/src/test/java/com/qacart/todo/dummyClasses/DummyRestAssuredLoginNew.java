package com.qacart.todo.dummyClasses;

import com.qacart.todo.api.LoginApi;

public class DummyRestAssuredLoginNew {
    public static void main(String[] args) {

        LoginApi loginApi = new LoginApi();
        loginApi.loginApi();
        System.out.println( loginApi.getRestAssuredCookeies());
        System.out.println( loginApi.getFirstName());
        System.out.println(  loginApi.getAccessToken());
        System.out.println( loginApi.getUserId());
    }


}
