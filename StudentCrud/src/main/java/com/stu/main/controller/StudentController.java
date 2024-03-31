package com.stu.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.stu.main.dto.StudentDTO;
import com.stu.main.model.Student;
import com.stu.main.service.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/student")
@Tag(name="Student Controller",description = "This is Student Crud ")
public class StudentController {

	// LOGGER
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<StudentDTO> studentSave(@RequestPart("Text_details") String studentInfo,
			@RequestPart("Profilephoto") MultipartFile studentProfilePic,
			@RequestPart("Sign") MultipartFile studentSignature) throws Exception {
		LOGGER.info("inside", Thread.currentThread().getStackTrace()[1].getMethodName());

		StudentDTO s = studentService.saveStudent(studentInfo, studentProfilePic, studentSignature);
		LOGGER.info("Exit ", Thread.currentThread().getStackTrace()[1].getMethodName());
		LOGGER.info("Exit ", Thread.currentThread().getStackTrace()[1].getMethodName());
		return new ResponseEntity<StudentDTO>(s, HttpStatus.CREATED);
	}

	@GetMapping("/retriveAll")
	public ResponseEntity<List<Student>> retriveAllStudents() {
		LOGGER.info("inside", Thread.currentThread().getStackTrace()[1].getMethodName());

		List<Student> allStudentList = studentService.getAllStudents();
		LOGGER.info("Exit ", Thread.currentThread().getStackTrace()[1].getMethodName());
		return new ResponseEntity<List<Student>>(allStudentList, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{rollno}")
	public ResponseEntity<String> deleteStudent(@PathVariable int rollno) {
		LOGGER.info("inside", Thread.currentThread().getStackTrace()[1].getMethodName());

		studentService.deleteStudent(rollno);
		LOGGER.info("Exit ", Thread.currentThread().getStackTrace()[1].getMethodName());
		return new ResponseEntity<String>("Student Deleted", HttpStatus.OK);
	}

	@GetMapping("/getStudentByRollNo/{rollno}")
	public ResponseEntity<StudentDTO> retriveStudent(@PathVariable("rollno") int id) {
		LOGGER.info("inside", Thread.currentThread().getStackTrace()[1].getMethodName());

		StudentDTO student = studentService.getStudent(id);
		LOGGER.info("Exit ", Thread.currentThread().getStackTrace()[1].getMethodName());
		return new ResponseEntity<StudentDTO>(student, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<StudentDTO> update(@RequestPart("Text_details") String student_Info,
			@RequestPart("Profilephoto") MultipartFile student_Profilepic,
			@RequestPart("Sign") MultipartFile student_Signature) throws Exception {

		LOGGER.info("inside", Thread.currentThread().getStackTrace()[1].getMethodName());

		StudentDTO s = studentService.saveStudent(student_Info, student_Profilepic, student_Signature);
		LOGGER.info("Exit ", Thread.currentThread().getStackTrace()[1].getMethodName());
		return new ResponseEntity<StudentDTO>(s, HttpStatus.CREATED);

	}

}
