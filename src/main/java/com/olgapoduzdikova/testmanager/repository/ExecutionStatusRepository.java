package com.olgapoduzdikova.testmanager.repository;

import com.olgapoduzdikova.testmanager.domain.ExecutionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutionStatusRepository extends JpaRepository<ExecutionStatus, String> {
}
