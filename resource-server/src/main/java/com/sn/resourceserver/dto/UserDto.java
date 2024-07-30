package com.sn.resourceserver.dto;

import com.sn.resourceserver.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String status;
    private ProfileDto profile;
    private boolean followed;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.status = user.getStatus();
        this.profile = new ProfileDto(user.getProfile());
        this.followed = user.isFollowed();
    }
}
