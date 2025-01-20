package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;
import com.qacart.todo.objects.User2;

public class UsersUtils {
    public static User generateRandomUsers()
    {
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password();
        User user = new User(firstName,lastName,email,password);
        User2 user2 = new User2(email ,password);
        return user ;
    }
    public static User2 generateRandomUsersLogin()
    {
        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password();
        User2 user2 = new User2(email ,password);
        return user2 ;
    }
}
