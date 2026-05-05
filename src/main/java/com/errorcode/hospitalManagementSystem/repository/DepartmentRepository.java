package com.errorcode.hospitalManagementSystem.repository;

import com.errorcode.hospitalManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}