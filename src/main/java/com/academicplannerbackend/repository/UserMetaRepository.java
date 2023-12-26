package com.academicplannerbackend.repository;

import com.academicplannerbackend.model.User;
import com.academicplannerbackend.model.UserMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMetaRepository extends JpaRepository<UserMeta, Long> {
    UserMeta findByUser(User id);
}
