package com.sn.resourceserver.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AttributeOverrides({
    @AttributeOverride(name = "mainLink", column = @Column(name = "main_link"))
})
public class Contact {
    private String github;
    private String vk;
    private String facebook;
    private String instagram;
    private String twitter;
    private String website;
    private String youtube;
    private String mainLink;
}
