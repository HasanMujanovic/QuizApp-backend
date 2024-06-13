package com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.userResponse;

import lombok.Data;

@Data
public class UserResponse {
    private int id;
    private String name;
    private String email;
    private String roles;
    private int level;
    private int points;
    private String status;
}
