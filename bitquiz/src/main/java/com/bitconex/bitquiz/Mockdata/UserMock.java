package com.bitconex.bitquiz.Mockdata;

import com.bitconex.bitquiz.entity.User;

public class UserMock {
    public static User getMockUserAdmin(){
        return User.builder().name("Seto").email("kaiba@gmail.com")
                .roles("admin").level(0).points(0).status("Public").build();
    }

    public static User getMockUserPlayer(){
        return User.builder().name("Yugi").email("dzedaj@gmail.com")
                .password("yugi123").roles("player").level(0).points(0).status("Private").build();
    }
}
