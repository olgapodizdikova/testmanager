package com.olgapoduzdikova.testmanager.repository;

import com.olgapoduzdikova.testmanager.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    @Modifying
    @Query("update Test t set t.status = :status where t.id = :id")
    void updateStatus(Long id, String status);
}
