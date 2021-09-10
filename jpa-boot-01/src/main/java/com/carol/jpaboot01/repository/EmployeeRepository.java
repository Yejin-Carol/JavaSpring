package com.carol.jpaboot01.repository;

import com.carol.jpaboot01.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
