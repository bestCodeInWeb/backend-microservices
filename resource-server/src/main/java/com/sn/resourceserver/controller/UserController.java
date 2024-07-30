package com.sn.resourceserver.controller;

import com.sn.resourceserver.dto.UserDto;
import com.sn.resourceserver.entity.User;
import com.sn.resourceserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers(
        @RequestParam(defaultValue = "10") Integer count,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam String term,
        @RequestParam Boolean friend) {

        PageRequest pageRequest = PageRequest.of(page, count);
        List<User> users = userService.getAll(term, friend, pageRequest);
        return users.stream().map(UserDto::new).collect(toList());
    }
}
