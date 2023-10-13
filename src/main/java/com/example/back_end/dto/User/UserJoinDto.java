package com.example.back_end.dto.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserJoinDto {
    private String name;
    private String password;

    @Builder
    public UserJoinDto(String name,
                       String password)
    {
        this.name = name;
        this.password = password;
    }
}
