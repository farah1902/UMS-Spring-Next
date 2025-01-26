package com.saadfarah.user_mngt_system_back.repository;

import com.saadfarah.user_mngt_system_back.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
