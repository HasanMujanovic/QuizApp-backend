package com.bitconex.bitquiz.architecture.request;

import lombok.Data;

@Data
public class UserRequest {
    private int id;
    private String name;
    private String email;
    private String roles;
    private int level;
    private int points;
}
