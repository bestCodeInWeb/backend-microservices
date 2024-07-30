package com.sn.resourceserver.service;

import com.sn.resourceserver.entity.User;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserService {
    List<User> getAll(String term, Boolean friend, PageRequest pageRequest);
}
