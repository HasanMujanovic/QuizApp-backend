package com.bitconex.bitquiz.architecture.dto.userDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String roles;
    private int level;
    private int points;

}
