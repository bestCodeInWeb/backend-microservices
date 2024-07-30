package com.sn.resourceserver.repository;

import com.sn.resourceserver.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
