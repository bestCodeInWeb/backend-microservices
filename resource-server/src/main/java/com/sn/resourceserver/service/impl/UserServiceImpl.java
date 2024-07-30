package com.sn.resourceserver.service.impl;

import com.sn.resourceserver.entity.User;
import com.sn.resourceserver.repository.UserRepository;
import com.sn.resourceserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAll(String term, Boolean friend, PageRequest pageRequest) {
        Specification<User> termSpecification = ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), term));
        Specification<User> specification = Specification.where(termSpecification);
        if(friend != null) {
            specification.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("followed"), friend));
        }

        return userRepository.findAll(specification, pageRequest);
    }
}
