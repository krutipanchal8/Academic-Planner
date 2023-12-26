package com.academicplannerbackend.repository;

import com.academicplannerbackend.model.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {
    VerificationCode findByCodeAndEmail(String code, String email);

    VerificationCode findByEmail(String email);
}
