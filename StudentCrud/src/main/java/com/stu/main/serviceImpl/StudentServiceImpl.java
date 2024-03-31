package com.stu.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stu.main.Utility.EntityDTOConvertor;
import com.stu.main.dto.StudentDTO;
import com.stu.main.model.Student;
import com.stu.main.repository.StudentRepostory;
import com.stu.main.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	// LOGGER 
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentRepostory studentRepository;

	@Autowired
	private EntityDTOConvertor convertor;

	@Override
	public StudentDTO saveStudent(String studentInfo, MultipartFile studentProfilePic, MultipartFile studentSignature) {
		LOGGER.info("inside", Thread.currentThread().getStackTrace()[1].getMethodName());
		StudentDTO studentDto = new StudentDTO();
		ObjectMapper obj = new ObjectMapper();
		Student studentDetail = new Student();
		try {
			studentDto = obj.readValue(studentInfo, StudentDTO.class);
			studentDto.setStudentProfilepic(studentProfilePic.getBytes());
			studentDto.setStudentSignature(studentSignature.getBytes());

			studentDetail = convertor.convertTo(studentDto, Student.class);
			studentRepository.save(studentDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("Exit ", Thread.currentThread().getStackTrace()[1].getMethodName());
		return convertor.convertTo(studentDetail, StudentDTO.class);
	}

	@Override
	public List<Student> getAllStudents() {
		LOGGER.info("inside", Thread.currentThread().getStackTrace()[1].getMethodName());

		List<Student> findAll = studentRepository.findAll();
		LOGGER.info("Exit ", Thread.currentThread().getStackTrace()[1].getMethodName());
		return findAll;
	}

	@Override
	public StudentDTO getStudent(int id) {
		LOGGER.info("inside", Thread.currentThread().getStackTrace()[1].getMethodName());

		
		
		
		Optional<Student> student = studentRepository.findById(id);
		Student student1 = new Student();
		if (student.isPresent()) {
			student1 = student.get();
		}
		LOGGER.info("Exit ", Thread.currentThread().getStackTrace()[1].getMethodName());
		return convertor.convertTo(student1, StudentDTO.class);
	}

	@Override
	public void deleteStudent(int rollno) {
		LOGGER.info("inside", Thread.currentThread().getStackTrace()[1].getMethodName());

		studentRepository.deleteById(rollno);
		LOGGER.info("Exit ", Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
