package com.ecommerce.demo.repositry;

import com.ecommerce.demo.model.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentrepo extends JpaRepository<student,Integer> {
}
