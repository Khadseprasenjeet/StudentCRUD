package com.stu.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stu.main.model.Student;
@Repository
public interface StudentRepostory extends JpaRepository<Student, Integer>{

}
