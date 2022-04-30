package com.example.ps_project.jparepository;

import com.example.ps_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserJpaRepository extends JpaRepository<User,Long> {
}
