package com.qacart.todo.dummyClasses;

import com.qacart.todo.api.RegisterApi;

public class DummyRegisterNew {
    public static void main(String[] args) {


        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        System.out.println(registerApi.getRestAssuredCookeies());
        System.out.println(registerApi.getuserId());
        System.out.println(registerApi.getFirstName());
    }
}
