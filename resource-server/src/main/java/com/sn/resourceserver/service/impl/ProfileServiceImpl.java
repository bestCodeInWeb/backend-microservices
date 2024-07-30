package com.sn.resourceserver.service.impl;

import com.sn.resourceserver.dto.ProfileDto;
import com.sn.resourceserver.entity.Profile;
import com.sn.resourceserver.repository.ProfileRepository;
import com.sn.resourceserver.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    @Override
    @Transactional
    public void updateProfile(ProfileDto profile) {
        Profile oldProfile = profileRepository.getReferenceById(profile.getId());
        oldProfile.setContact(profile.getContact());
        oldProfile.setPhotos(profile.getPhotos());
        oldProfile.setLookingForAJobDescription(profile.getLookingForAJobDescription());
        oldProfile.setLookingForAJob(profile.isLookingForAJob());
    }
}
