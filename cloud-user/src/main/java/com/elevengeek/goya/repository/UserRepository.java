package com.elevengeek.goya.repository;

import com.elevengeek.goya.entiy.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cj
 * @create 2020-02-04-16:42
 */
public interface UserRepository extends JpaRepository<UserEntity,String> {
}
