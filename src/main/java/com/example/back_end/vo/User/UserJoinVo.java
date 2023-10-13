package com.example.back_end.vo.User;

import com.example.back_end.Entity.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserJoinVo {
    private Integer id;
    private String name;

    public static UserJoinVo fromUser(User user) {
        return new UserJoinVo(
                user.getId(),
                user.getUsername()
        );
    }
}
