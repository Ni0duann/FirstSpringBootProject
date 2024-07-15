package com.demo.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<student, Long>, JpaSpecificationExecutor<student> {


    List<student> findByEmail(String email);

    List<student> findByAgeBetween(int minAge, int maxAge);
}
