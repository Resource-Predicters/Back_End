package com.example.back_end.dto.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserLoginDto {
    private String name;
    private String password;

    @Builder
    public UserLoginDto(String name,
                       String password)
    {
        this.name = name;
        this.password = password;
    }
}
