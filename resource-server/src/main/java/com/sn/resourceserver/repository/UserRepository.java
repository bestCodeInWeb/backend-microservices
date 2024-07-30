package com.sn.resourceserver.repository;

import com.sn.resourceserver.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll(Specification<User> specification, Pageable pageRequest);
}
