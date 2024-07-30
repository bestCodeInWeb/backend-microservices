package com.sn.resourceserver.dto;

import com.sn.resourceserver.entity.Contact;
import com.sn.resourceserver.entity.Photo;
import com.sn.resourceserver.entity.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDto {
    private Long id;
    private boolean lookingForAJob;
    private String lookingForAJobDescription;
    private String fullName;
    private Contact contact;
    private Photo photos;

    public ProfileDto(Profile profile) {
        this.id = id;
        this.lookingForAJob = profile.isLookingForAJob();
        this.lookingForAJobDescription = profile.getLookingForAJobDescription();
        this.fullName = profile.getFullName();
        this.contact = profile.getContact();
        this.photos = profile.getPhotos();
    }
}
