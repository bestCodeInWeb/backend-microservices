package com.sn.resourceserver.controller;

import com.sn.resourceserver.dto.ProfileDto;
import com.sn.resourceserver.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PutMapping("/")
    public Object updateProfile(@RequestBody ProfileDto profileDto) {
        profileService.updateProfile(profileDto);
        return new Object(); //todo
    }
}
