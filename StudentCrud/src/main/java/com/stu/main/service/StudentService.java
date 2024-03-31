package com.stu.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.stu.main.dto.StudentDTO;
import com.stu.main.model.Student;

public interface StudentService {

public StudentDTO saveStudent(String student_Info, MultipartFile student_Profilepic, MultipartFile student_Signature) throws Exception;

public List<Student> getAllStudents();

public StudentDTO getStudent(int id);

public void deleteStudent(int rollno);
	
	

}
